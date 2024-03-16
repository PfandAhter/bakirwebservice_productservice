package com.bakirwebservice.productservice.rest.controller;

import com.bakirwebservice.productservice.api.CategoryApi;
import com.bakirwebservice.productservice.api.request.CategoryAddRequest;
import com.bakirwebservice.productservice.api.request.CategoryListRequest;
import com.bakirwebservice.productservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.CategoryListResponse;
import com.bakirwebservice.productservice.rest.service.impl.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@Slf4j
@RequiredArgsConstructor
@CrossOrigin

public class CategoryController implements CategoryApi {

    private final CategoryServiceImpl categoryService;

    @Override
    public ResponseEntity<CategoryListResponse> listCategory(CategoryListRequest categoryListRequest, HttpServletRequest request) {
        return ResponseEntity.ok().body(categoryService.listCategory(categoryListRequest));
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
