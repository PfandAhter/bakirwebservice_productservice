package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.client.UserServiceClient;
import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.request.ReduceStockRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.exceptions.OutOfStockException;
import com.bakirwebservice.stockservice.infra.impl.HeaderServiceImpl;
import com.bakirwebservice.stockservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.stockservice.model.dto.CommentDTO;
import com.bakirwebservice.stockservice.model.dto.ProductDTO;
import com.bakirwebservice.stockservice.model.dto.ProductGetDTO;
import com.bakirwebservice.stockservice.model.entity.Company;
import com.bakirwebservice.stockservice.model.entity.Product;
import com.bakirwebservice.stockservice.repository.CommentRepository;
import com.bakirwebservice.stockservice.repository.CompanyRepository;
import com.bakirwebservice.stockservice.repository.ProductRepository;
import com.bakirwebservice.stockservice.rest.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final MapperServiceImpl mapperService;

    private final CompanyRepository companyRepository;

    private final HttpServletRequest request;

    private final HeaderServiceImpl headerService;

    private final UserServiceClient userServiceClient;

    private final CommentRepository commentRepository;


    @Override
    public ProductGetResponse getProduct(String productId) {
        ProductGetDTO productGetDTOS = mapperService.map(productRepository.findProductsByProductId(productId), ProductGetDTO.class);
        productGetDTOS.setComments(mapperService.map(commentRepository.findCommentsByProductId(productId), CommentDTO.class));
        Integer commentCount = commentRepository.findCommentCount(productId);

        productGetDTOS.setCommentCount(Objects.requireNonNullElse(commentCount, 0)); // NEW

        ProductGetResponse productGetResponse = new ProductGetResponse();
        productGetResponse.setProductInfo(productGetDTOS);

        return productGetResponse;
    }

    @Override
    public ProductListResponse listProduct(String categoryId) {
        List<ProductDTO> productDTOList = mapperService.map(productRepository.findProductsByCategoryId(categoryId), ProductDTO.class);
        for (ProductDTO productDTO : productDTOList) {
            Integer commentCount = commentRepository.findCommentCount(productDTO.getProductId());
            productDTO.setCommentCount(Objects.requireNonNullElse(commentCount, 0));

        }

        return new ProductListResponse(productDTOList);
    }

    @Override
    @Transactional
    //TODO yani bu addproduct olayinda adam category id yerine category adi ve sirket adi girsin gerisini arka taraf halletsin.
    public BaseResponse addProduct(ProductAddRequest productAddRequest) {
        String localUserRole = userServiceClient.extractRoleFromToken(productAddRequest);

        if (localUserRole.equals("SELLER") || localUserRole.equals("ADMIN")) {
            if (companyRepository.findCompanyByCompanyName(productAddRequest.getCompanyName()) == null) {
                companyRepository.save(Company.builder().companyName(productAddRequest.getCompanyName().toUpperCase()).build());
            }
            String localSellerUsername = userServiceClient.extractSellerNameFromToken(productAddRequest);

            if (localSellerUsername.isEmpty() && localUserRole.equals("ADMIN")) {
                localSellerUsername = "bakirwebservice";
            }

            String companyId = companyRepository.findCompanyByCompanyName(productAddRequest.getCompanyName().toUpperCase()).getCompanyId();
            Product product = mapperService.map(productAddRequest, Product.class);
            product.setProductName(localSellerUsername);
            product.setCompanyId(companyId);

            productRepository.save(product);
            return new BaseResponse();
        } else {
            throw new org.springframework.security.access.AccessDeniedException("ACCESS DENIED");
        }
    }

    @Override
    public BaseResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findProductsByProductId(productUpdateRequest.getProductId());
        String localUserRole = userServiceClient.extractRoleFromToken(productUpdateRequest);

        if (localUserRole.equals("ADMIN") || localUserRole.equals("SELLER")) {
            if (product != null) {
                mapperService.map(productUpdateRequest, product);
                productRepository.save(product);
                return new BaseResponse();
            } else {
                throw new org.springframework.security.access.AccessDeniedException("NO PRODUCT FOUND WITH THIS INFO ");
            }
        } else {
            throw new org.springframework.security.access.AccessDeniedException("ACCESS DENIED");
        }

    }

    @Override
    @Transactional
    public BaseResponse reduceStock(ReduceStockRequest request) throws OutOfStockException {
        Product product = productRepository.findProductsByProductId(request.getProductId());

        if (product.getStock() >= request.getOrderQuantity()) {
            product.setStock(product.getStock() - request.getOrderQuantity());
            productRepository.save(product);
        } else {
            if (product.getStockNeed() == 0) {
                Timestamp timeStamp = Timestamp.from(Instant.now());
                product.setOutOfStockDate(timeStamp);
            }
            product.setActive(2);
            product.setStockNeed(product.getStockNeed() + 1);
            productRepository.save(product);
            throw new OutOfStockException("OUT OF STOCK");
        }

        return new BaseResponse();
    }

}
