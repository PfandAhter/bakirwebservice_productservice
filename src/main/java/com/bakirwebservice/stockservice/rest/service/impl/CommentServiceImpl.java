package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.client.PaymentServiceClient;
import com.bakirwebservice.stockservice.api.client.TokenServiceClient;
import com.bakirwebservice.stockservice.api.request.CommentAddRequest;
import com.bakirwebservice.stockservice.api.request.UserOrderedProductRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.api.response.CommentListResponse;
import com.bakirwebservice.stockservice.exceptions.AccessDeniedException;
import com.bakirwebservice.stockservice.infra.impl.MapperServiceImpl;
import com.bakirwebservice.stockservice.model.dto.CommentDTO;
import com.bakirwebservice.stockservice.model.entity.Comment;
import com.bakirwebservice.stockservice.repository.CommentRepository;
import com.bakirwebservice.stockservice.rest.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor

public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final MapperServiceImpl mapperService;

    private final TokenServiceClient tokenServiceClient;

    private final PaymentServiceClient paymentServiceClient;

    public BaseResponse commentSave (String productId, CommentAddRequest commentAddRequest) throws AccessDeniedException {
        String localUsername = tokenServiceClient.extractedUsername(commentAddRequest);
        UserOrderedProductRequest userOrderedProductRequest = new UserOrderedProductRequest();
        userOrderedProductRequest.setProductId(productId);
        userOrderedProductRequest.setUsername(localUsername);

        if(paymentServiceClient.userHasOrder(userOrderedProductRequest)){
            commentRepository.save(Comment.builder().productId(productId).comment(commentAddRequest.getComment()).username(localUsername).createDate(Timestamp.from(Instant.now())).build());
            return new BaseResponse();
        }else{
            throw new AccessDeniedException("YOU CAN'T COMMENT ON THIS PRODUCT");
        }
    }

    public CommentListResponse commentList (String productId){
        return new CommentListResponse(mapperService.map(commentRepository.findCommentsByProductId(productId), CommentDTO.class));
    }
}
