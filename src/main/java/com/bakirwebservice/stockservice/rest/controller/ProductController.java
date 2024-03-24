package com.bakirwebservice.stockservice.rest.controller;

import com.bakirwebservice.stockservice.api.ProductApi;
import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.rest.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final ProductServiceImpl productService;

    @Override
    public ResponseEntity<ProductGetResponse> getProduct(String productId) {
        return ResponseEntity.ok().body(productService.getProduct(productId));
    }

    @Override
    public ResponseEntity<ProductListResponse> listProduct(String categoryId) {
        return ResponseEntity.ok().body(productService.listProduct(categoryId));
    }

    @Override
    public ResponseEntity<BaseResponse> addProduct(ProductAddRequest productAddRequest) {
        return ResponseEntity.ok().body(productService.addProduct(productAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> updateProduct(ProductUpdateRequest productUpdateRequest) {
        return ResponseEntity.ok().body(productService.updateProduct(productUpdateRequest));
    }
}

