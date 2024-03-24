package com.bakirwebservice.stockservice.api;

import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("product")
public interface ProductApi {

    @GetMapping("get")
    ResponseEntity<ProductGetResponse> getProduct(@RequestParam("product") String productId);

    @GetMapping("list")
    ResponseEntity<ProductListResponse> listProduct(@RequestParam("category") String categoryId);

    @PostMapping("add")
    ResponseEntity<BaseResponse> addProduct(@RequestBody @Valid ProductAddRequest productAddRequest);

    @PostMapping("update")
    ResponseEntity<BaseResponse> updateProduct(@RequestBody @Valid ProductUpdateRequest productUpdateRequest);

}
