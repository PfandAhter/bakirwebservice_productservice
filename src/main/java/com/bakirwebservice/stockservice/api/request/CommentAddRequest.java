package com.bakirwebservice.stockservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentAddRequest extends BaseRequest{

    private String comment;
}
