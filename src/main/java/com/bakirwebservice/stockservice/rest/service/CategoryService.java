package com.bakirwebservice.stockservice.rest.service;

import com.bakirwebservice.stockservice.api.request.CategoryAddRequest;
import com.bakirwebservice.stockservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CategoryListResponse;

public interface CategoryService {
    CategoryListResponse listCategory(String categoryId);

    BaseResponse addCategory(CategoryAddRequest categoryAddRequest);

    BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest);

}
