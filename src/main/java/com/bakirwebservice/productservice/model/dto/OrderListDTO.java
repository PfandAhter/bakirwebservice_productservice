package com.bakirwebservice.productservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrderListDTO {

    private String productName;
    private String companyName;
    private String categoryName;
    private Long productCode;
    private Long price;
    private int orderQuantity;
    private Long totalPriceOnCart;
    private String status;
    private String description;
}
