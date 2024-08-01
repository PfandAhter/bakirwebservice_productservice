package com.bakirwebservice.stockservice.api;

import com.bakirwebservice.stockservice.api.request.BaseRequest;
import com.bakirwebservice.stockservice.api.request.ProductAddRequest;
import com.bakirwebservice.stockservice.api.request.ProductUpdateRequest;
import com.bakirwebservice.stockservice.api.request.ReduceStockRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.ProductGetResponse;
import com.bakirwebservice.stockservice.api.response.ProductListResponse;
import com.bakirwebservice.stockservice.exceptions.AccessDeniedException;
import com.bakirwebservice.stockservice.exceptions.OutOfStockException;
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

    @PostMapping("stock/reduce")
    ResponseEntity<BaseResponse>  reduceStock (@RequestBody @Valid ReduceStockRequest reduceStockRequest) throws OutOfStockException;

}
