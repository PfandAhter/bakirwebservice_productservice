package com.bakirwebservice.stockservice.rest.controller;

import com.bakirwebservice.stockservice.api.CommentApi;
import com.bakirwebservice.stockservice.api.request.CommentAddRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CommentListResponse;
import com.bakirwebservice.stockservice.exceptions.AccessDeniedException;
import com.bakirwebservice.stockservice.rest.service.impl.CommentServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j

public class CommentController implements CommentApi {

    private final CommentServiceImpl commentService;

    @Override
    public ResponseEntity<BaseResponse> addComment(String productId, CommentAddRequest commentAddRequest) throws AccessDeniedException {
        return ResponseEntity.ok(commentService.commentSave(productId,commentAddRequest));
    }

    @Override
    public ResponseEntity<CommentListResponse> listComment(String productId) {
        return ResponseEntity.ok(commentService.commentList(productId));
    }

}
