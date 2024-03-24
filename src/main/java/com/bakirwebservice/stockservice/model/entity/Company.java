package com.bakirwebservice.stockservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "company")
@Entity
@Getter
@Setter

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id")
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

}
