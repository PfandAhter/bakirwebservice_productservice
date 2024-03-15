package com.bakirwebservice.productservice.rest.controller;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.GetCategoryListRequest;
import com.bakirwebservice.productservice.model.constants.PropertyConstants;
import com.bakirwebservice.productservice.model.dto.CategoryDTO;
import com.bakirwebservice.productservice.rest.controller.api.CategoryRestServiceApi;
import com.bakirwebservice.productservice.rest.service.CategoryServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(path = PropertyConstants.REQUEST_CATEGORYSERVICE)
@Controller
@Slf4j
@RequiredArgsConstructor
@CrossOrigin

public class CategoryServiceController implements CategoryRestServiceApi {

    private final CategoryServiceImpl categoryService;

    @Override
    public ResponseEntity<List<CategoryDTO>> categoryListResponse(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(categoryService.categoryListResponse(baseRequest));
    }

}
