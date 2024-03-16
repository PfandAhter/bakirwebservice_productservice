package com.bakirwebservice.productservice.model.dto;

import com.bakirwebservice.productservice.model.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class CategoryDTO {

    private Long categoryId;

    private Long parentId;

    private String categoryName;

    private String status;

    private Set<Category> children;

}