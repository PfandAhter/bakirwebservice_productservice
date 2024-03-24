package com.bakirwebservice.stockservice.rest.controller;

import com.bakirwebservice.stockservice.api.CategoryApi;
import com.bakirwebservice.stockservice.api.request.CategoryAddRequest;
import com.bakirwebservice.stockservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CategoryListResponse;
import com.bakirwebservice.stockservice.rest.service.impl.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CategoryController implements CategoryApi {

    private final CategoryServiceImpl categoryService;

    @Override
    public ResponseEntity<CategoryListResponse> listCategory(String categoryId, HttpServletRequest request) {
        return ResponseEntity.ok().body(categoryService.listCategory(categoryId));
    }

    @Override
    public ResponseEntity<BaseResponse> addCategory(CategoryAddRequest categoryAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok().body(categoryService.addCategory(categoryAddRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> updateCategory(CategoryUpdateRequest categoryUpdateRequest, HttpServletRequest request) {
        return ResponseEntity.ok().body(categoryService.updateCategory(categoryUpdateRequest));
    }

}
