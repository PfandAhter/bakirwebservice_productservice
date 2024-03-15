package com.bakirwebservice.productservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "company")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long company_id;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "company",
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Product> products;
}
