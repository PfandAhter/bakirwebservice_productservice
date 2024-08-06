package com.bakirwebservice.stockservice.api;

import com.bakirwebservice.stockservice.api.request.CommentAddRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CommentListResponse;
import com.bakirwebservice.stockservice.exceptions.AccessDeniedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("comment")
public interface CommentApi {

    @PostMapping("add")
    ResponseEntity<BaseResponse> addComment (@RequestParam("productid") String productId ,@RequestBody CommentAddRequest commentAddRequest) throws AccessDeniedException;

    @GetMapping("list")
    ResponseEntity<CommentListResponse> listComment (@RequestParam("productid") String productId);
}
