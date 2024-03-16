package com.bakirwebservice.productservice.api;


import com.bakirwebservice.productservice.api.request.CategoryAddRequest;
import com.bakirwebservice.productservice.api.request.CategoryListRequest;
import com.bakirwebservice.productservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.CategoryListResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("category")
public interface CategoryApi {

    @PostMapping("list")
    ResponseEntity<CategoryListResponse> listCategory(@RequestBody CategoryListRequest categoryListRequest, HttpServletRequest request);

    @PostMapping("add")
    ResponseEntity<BaseResponse> addCategory(@RequestBody CategoryAddRequest categoryAddRequest, HttpServletRequest request);

    @PostMapping("update")
    ResponseEntity<BaseResponse> updateCategory(@RequestBody CategoryUpdateRequest categoryAddRequest, HttpServletRequest request);
}
