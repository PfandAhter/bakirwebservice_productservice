package com.bakirwebservice.stockservice.api.response;

import com.bakirwebservice.stockservice.model.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class CommentListResponse {
    List<CommentDTO> commentList;
}
