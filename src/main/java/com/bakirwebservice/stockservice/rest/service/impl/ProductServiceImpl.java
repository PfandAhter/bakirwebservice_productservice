package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.stockservice.model.dto.ProductDTO;
import com.bakirwebservice.stockservice.model.entity.Product;
import com.bakirwebservice.stockservice.repository.CategoryRepository;
import com.bakirwebservice.stockservice.repository.ProductRepository;
import com.bakirwebservice.stockservice.rest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.bakirwebservice.stockservice.lib.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME;

@Service
@Slf4j
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final MapperServiceImpl mapperService;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME)
    private String extractUsernamePaths;

    @Override
    public ProductGetResponse getProduct(String productId) {
        return new ProductGetResponse(mapperService.map(productRepository.findProductsByProductId(productId), ProductDTO.class));
    }

    @Override
    public ProductListResponse listProduct(String categoryId) {
        return new ProductListResponse(mapperService.map(productRepository.findProductsByCategoryId(categoryId), ProductDTO.class));
    }

    @Override
    @Transactional
    public BaseResponse addProduct(ProductAddRequest productAddRequest) {
        productRepository.save(mapperService.map(productAddRequest, Product.class));
        return new BaseResponse();
    }

    @Override
    public BaseResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        Product product = productRepository.findProductsByProductId(productUpdateRequest.getProductId());
        if (product != null) {
            mapperService.map(productUpdateRequest, product);
            productRepository.save(product);
        }
        return new BaseResponse();
    }
}
