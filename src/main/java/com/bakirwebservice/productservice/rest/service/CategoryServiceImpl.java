package com.bakirwebservice.productservice.rest.service;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.model.dto.CategoryDTO;
import com.bakirwebservice.productservice.repository.CategoryRepository;
import com.bakirwebservice.productservice.rest.service.interfaces.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CategoryServiceImpl implements ICategoryService {

    private final MapperServiceImpl mapperService;

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> categoryListResponse(BaseRequest request){
        return mapperService.map(categoryRepository.findAll(), CategoryDTO.class);
    }
}
