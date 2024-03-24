package com.bakirwebservice.stockservice.rest.service;


import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;

public interface ProductService {

    ProductGetResponse getProduct(String productId);

    ProductListResponse listProduct(String categoryId);

    BaseResponse addProduct(ProductAddRequest productAddRequest);

    BaseResponse updateProduct(ProductUpdateRequest productUpdateRequest);

}
