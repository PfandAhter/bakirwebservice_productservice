package com.bakirwebservice.stockservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_id")
    private String commentId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "username")
    private String username;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date")
    private Timestamp createDate;

    @Column(name = "active")
    private int active;

}
