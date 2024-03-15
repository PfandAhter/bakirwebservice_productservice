package com.bakirwebservice.productservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductDTO {

    private String productName;
    private String companyName;
    private String categoryName;
    private String productCode;
    private int price;
    private int stock;
    private String description;

}
