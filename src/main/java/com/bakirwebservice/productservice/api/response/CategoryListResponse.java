package com.bakirwebservice.productservice.api.response;

import com.bakirwebservice.productservice.model.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryListResponse {

    private List<CategoryDTO> categoryList;
}
