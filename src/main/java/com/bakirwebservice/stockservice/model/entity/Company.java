package com.bakirwebservice.stockservice.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "company")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "company_id")
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "active")
    private int active;

    @Column(name = "status")
    private String status;

}
