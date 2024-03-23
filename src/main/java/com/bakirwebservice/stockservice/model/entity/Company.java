package com.bakirwebservice.stockservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "company")
@Entity
@Getter
@Setter

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id")
    private String company_id;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "company",
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Product> products;
}
