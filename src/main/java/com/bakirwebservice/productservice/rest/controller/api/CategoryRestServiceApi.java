package com.bakirwebservice.productservice.rest.controller.api;


import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.model.constants.PropertyConstants;
import com.bakirwebservice.productservice.model.dto.CategoryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryRestServiceApi {
    @PostMapping(path = PropertyConstants.CATEGORY_LIST , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CategoryDTO>> categoryListResponse (@RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);
}
