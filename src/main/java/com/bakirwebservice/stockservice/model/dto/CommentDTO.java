package com.bakirwebservice.stockservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter

public class CommentDTO {
    private String productId;
    private String username;
    private String comment;
    private Timestamp createDate;
}
