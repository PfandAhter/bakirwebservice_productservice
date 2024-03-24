package com.bakirwebservice.stockservice.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "product")
@Entity
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;


}
