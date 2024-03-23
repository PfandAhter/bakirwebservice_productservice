package com.bakirwebservice.stockservice.api;


import com.bakirwebservice.stockservice.api.request.CategoryAddRequest;
import com.bakirwebservice.stockservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CategoryListResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("category")
public interface CategoryApi {

    @GetMapping("list")
    ResponseEntity<CategoryListResponse> listCategory(@RequestParam("category") String categoryId, HttpServletRequest request);

    @PostMapping("add")
    ResponseEntity<BaseResponse> addCategory(@RequestBody @Valid CategoryAddRequest categoryAddRequest, HttpServletRequest request);

    @PostMapping("update")
    ResponseEntity<BaseResponse> updateCategory(@RequestBody @Valid CategoryUpdateRequest categoryAddRequest, HttpServletRequest request);
}
