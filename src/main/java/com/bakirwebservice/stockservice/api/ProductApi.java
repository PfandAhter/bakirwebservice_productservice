package com.bakirwebservice.stockservice.api;

import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("product")
public interface ProductApi {

    @GetMapping("list")
    ProductListResponse listProduct(String productId, String categoryId);

    @PostMapping("add")
    BaseResponse addProduct(@RequestBody @Valid ProductAddRequest productAddRequest);


    @PostMapping("update")
    BaseResponse updateProduct(@RequestBody @Valid ProductUpdateRequest productUpdateRequest);

}
