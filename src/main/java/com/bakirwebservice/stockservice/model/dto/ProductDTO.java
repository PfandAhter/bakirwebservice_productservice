package com.bakirwebservice.stockservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    private String productId;

    private String productName;

    private String categoryId;

    private BigDecimal price;

    private int stock;

    private String description;

}
