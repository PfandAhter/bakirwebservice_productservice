package com.bakirwebservice.stockservice.rest.controller;

import com.bakirwebservice.stockservice.api.ProductApi;
import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.rest.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

// /productservice/product
@Controller
@CrossOrigin
@Slf4j
@RequiredArgsConstructor

public class ProductController implements ProductApi {

    private final ProductServiceImpl productService;


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
