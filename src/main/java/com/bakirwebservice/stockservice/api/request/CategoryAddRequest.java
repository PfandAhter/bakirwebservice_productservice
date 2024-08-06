package com.bakirwebservice.stockservice.api.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAddRequest extends BaseRequest {

    @NotBlank(message = "categoryName NOT NULL")
    private String categoryName;

    @NotBlank(message = "status NOT NULL")
    private String status;

    private String parentId;

}
