package com.bakirwebservice.productservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderWithProductCodeRequest extends BaseRequest{
    private String username;

    private Long productCode;

    private int orderQuantity;
}

