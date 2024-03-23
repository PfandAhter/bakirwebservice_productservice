package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.stockservice.repository.CategoryRepository;
import com.bakirwebservice.stockservice.repository.ProductRepository;
import com.bakirwebservice.stockservice.rest.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.bakirwebservice.stockservice.lib.constants.PropertyConstants.REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME;

@Service
@Slf4j
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final MapperServiceImpl mapperService;

    @Value(REST_TEMPLATE_REQUEST_MICROSERVICE_TOKEN_SERVICE_EXTRACT_USERNAME)
    private String extractUsernamePaths;


    @Override
    public ProductListResponse listProduct(String productId, String categoryId) {
        return null;
    }

    @Override
    public BaseResponse addProduct(ProductAddRequest productAddRequest) {
        return null;
    }

    @Override
    public BaseResponse updateProduct(ProductUpdateRequest productUpdateRequest) {
        return null;
    }
}
