package com.bakirwebservice.productservice.rest.service.interfaces;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.model.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> categoryListResponse(BaseRequest request);

}
