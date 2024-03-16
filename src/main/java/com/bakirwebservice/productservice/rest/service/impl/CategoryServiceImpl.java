package com.bakirwebservice.productservice.rest.service.impl;

import com.bakirwebservice.productservice.api.request.CategoryAddRequest;
import com.bakirwebservice.productservice.api.request.CategoryListRequest;
import com.bakirwebservice.productservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.CategoryListResponse;
import com.bakirwebservice.productservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.productservice.model.dto.CategoryDTO;
import com.bakirwebservice.productservice.model.entity.Category;
import com.bakirwebservice.productservice.repository.CategoryRepository;
import com.bakirwebservice.productservice.rest.service.CategoryService;
import com.bakirwebservice.productservice.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CategoryServiceImpl implements CategoryService {

    private final MapperServiceImpl mapperService;

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryListResponse listCategory(CategoryListRequest categoryListRequest) {
        return new CategoryListResponse(mapperService.map(categoryRepository.findCategoriesByCriteria(categoryListRequest.getCategoryId()), CategoryDTO.class));
    }

    @Override
    @Transactional
    public BaseResponse addCategory(CategoryAddRequest categoryAddRequest) {
        categoryRepository.save(mapperService.map(categoryAddRequest, Category.class));
        return new BaseResponse();
    }

    @Override
    @Transactional
    public BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest) {
        Category category = categoryRepository.findCategoryByCategoryId(categoryUpdateRequest.getCategoryId());
        mapperService.map(categoryUpdateRequest, category);
        categoryRepository.save(category);
        return new BaseResponse();
    }
}
