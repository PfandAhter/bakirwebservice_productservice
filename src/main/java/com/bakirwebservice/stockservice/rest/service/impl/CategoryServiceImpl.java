package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.client.UserServiceClient;
import com.bakirwebservice.stockservice.api.request.BaseRequest;
import com.bakirwebservice.stockservice.api.request.CategoryAddRequest;
import com.bakirwebservice.stockservice.api.request.CategoryUpdateRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CategoryListResponse;
import com.bakirwebservice.stockservice.infra.impl.HeaderServiceImpl;
import com.bakirwebservice.stockservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.stockservice.model.dto.CategoryDTO;
import com.bakirwebservice.stockservice.model.entity.Category;
import com.bakirwebservice.stockservice.repository.CategoryRepository;
import com.bakirwebservice.stockservice.rest.service.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j

public class CategoryServiceImpl implements CategoryService {

    private final MapperServiceImpl mapperService;

    private final CategoryRepository categoryRepository;

    private final UserServiceClient userServiceClient;

    @Override
    public CategoryListResponse listCategory(String categoryId) {
        return new CategoryListResponse(mapperService.map(categoryRepository.findCategoriesByCriteria(categoryId), CategoryDTO.class));
    }

    @Override
    @Transactional
    public BaseResponse addCategory(CategoryAddRequest categoryAddRequest) {
        String localUserRole = userServiceClient.extractRoleFromToken(categoryAddRequest);

        if(localUserRole.equals("ADMIN")) {
            categoryRepository.save(mapperService.map(categoryAddRequest, Category.class));
            return new BaseResponse();
        }else{
            throw new org.springframework.security.access.AccessDeniedException("ACCESS DENIED");
        }
    }

    @Override
    @Transactional
    public BaseResponse updateCategory(CategoryUpdateRequest categoryUpdateRequest) {
        String localUserRole = userServiceClient.extractRoleFromToken(categoryUpdateRequest);

        if(localUserRole.equals("ADMIN")) {
            Category category = categoryRepository.findCategoryByCategoryId(categoryUpdateRequest.getCategoryId());
            mapperService.map(categoryUpdateRequest, category);
            categoryRepository.save(category);
            return new BaseResponse();
        }else{
            throw new org.springframework.security.access.AccessDeniedException("ACCESS DENIED");
        }
    }

}
