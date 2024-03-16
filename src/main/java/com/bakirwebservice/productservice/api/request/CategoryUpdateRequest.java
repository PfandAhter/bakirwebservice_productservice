package com.bakirwebservice.productservice.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequest extends CategoryAddRequest {

    @NotBlank
    private Long categoryId;
}
