package com.bakirwebservice.productservice.rest.service;

import com.bakirwebservice.productservice.api.request.*;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.dto.OrderListDTO;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import com.bakirwebservice.productservice.model.dto.ProductDetails;
import com.bakirwebservice.productservice.model.entity.Product;
import com.bakirwebservice.productservice.repository.CategoryRepository;
import com.bakirwebservice.productservice.repository.ProductRepository;
import com.bakirwebservice.productservice.rest.service.interfaces.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bakirwebservice.productservice.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_CREATE_ORDER;
import static com.bakirwebservice.productservice.model.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME;

@Service
@Slf4j
@RequiredArgsConstructor

public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final MapperServiceImpl mapperService;

    private final RestTemplate restTemplate;

    private final ModelMapper modelMapper;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME)
    private String extractUsernamePaths;

    @Override
    public List<ProductDTO> productListResponse(BaseRequest request) {
        return mapperService.modelMapper(productRepository.findAll(), ProductDTO.class);

    }

    @Override
    public List<ProductDTO> categoryListByCategoryName(GetCategoryListRequest request) {
        return mapperService.modelMapper(Arrays.asList(productRepository.findProductsByCategory(categoryRepository.findByCategoryName(request.getCategoryName()))), ProductDTO.class);

    }

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_PAYMENT_SERVICE_CREATE_ORDER)
    private String createOrderFromPaymentServicePath;

    @Override
    public BaseResponse createOrder(CreateOrderWithProductCodeRequest request) {
        if (productRepository.findProductByProductCode(request.getProductCode()).getStock() > 0) {
            String localUsername = restTemplate.postForObject(extractUsernamePaths, request, String.class);
            request.setUsername(localUsername);
            restTemplate.postForObject(createOrderFromPaymentServicePath, request, BaseResponse.class);
        }
        return new BaseResponse();
        //check if balance amount is not enough for buying
    }

    @Override
    public GetProductDetailsResponse getProductInfoByProductCode(ArrayList<OrderListDTO> request) {
        Long localTotalAmount = 0L;

        List<GetProductDetailsResponse> getProductDetailsResponseList = new ArrayList<>();

        ProductDetails test = (ProductDetails) new GetProductDetailsResponse().getProductDetailsList();

        GetProductDetailsResponse getProductDetailsResponse = new GetProductDetailsResponse();

        for (int i = 0; i < request.size(); i++) {
            Product localProduct = productRepository.findByProductCode(request.get(i).getProductCode());
            getProductDetailsResponse.setProductDetailsList(modelMapper.map(localProduct, ArrayList.class));

            getProductDetailsResponseList.add(getProductDetailsResponse);
//            productDetailsResponseList.add(GetProductDetailsResponse.builder().productDetailsList()
//                    .productName(localProduct.getProductName())
//                    .companyName(localProduct.getCompany().getCompanyName())
//                    .categoryName(localProduct.getCategory().getCategoryName())
//                    .productCode(localProduct.getProductCode())
//                    .price(localProduct.getPrice())
//                    .orderQuantity(request.get(i).getOrderQuantity())
//                    .description(localProduct.getDescription())
//                    .build());
            localTotalAmount += localProduct.getPrice();
        }
        for(int i = 0 ;i< request.size();i++){
            getProductDetailsResponseList.get(0).getProductDetailsList().get(i).setTotalPriceOnCart(localTotalAmount);
        }

        return getProductDetailsResponse;
    }

}
