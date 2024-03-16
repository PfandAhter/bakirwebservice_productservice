package com.bakirwebservice.productservice.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "parent_id")
    @JoinColumn(name = "category_id")
    private String parentId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "parentId",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Category> children;

    @Column(name = "status")
    private String status;

}


