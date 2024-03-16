package com.bakirwebservice.productservice.rest.service;

import com.bakirwebservice.productservice.api.request.CategoryAddRequest;
import com.bakirwebservice.productservice.api.request.CategoryListRequest;
import com.bakirwebservice.productservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.CategoryListResponse;

public interface CategoryService {
    CategoryListResponse listCategory(CategoryListRequest categoryListRequest);

    BaseResponse addCategory(CategoryAddRequest categoryAddRequest);

    BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest);

}
