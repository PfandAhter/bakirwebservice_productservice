package com.bakirwebservice.stockservice.api.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddRequest extends BaseRequest{

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Long price;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;
}
