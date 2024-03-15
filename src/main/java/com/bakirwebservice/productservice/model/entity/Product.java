package com.bakirwebservice.productservice.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    //TODO BU PRODUCTCODE YAP... ORDER LIST ICIN

    @Column(name = "product_code")
    private Long productCode;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")
    private String description;




}
