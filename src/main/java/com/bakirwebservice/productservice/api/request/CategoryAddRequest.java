package com.bakirwebservice.productservice.api.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAddRequest extends BaseRequest {

    @NotBlank
    private String categoryName;

    @NotBlank
    private String status;

    private String parentId;

}
