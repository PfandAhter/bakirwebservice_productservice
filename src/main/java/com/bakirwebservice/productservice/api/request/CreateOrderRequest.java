package com.bakirwebservice.productservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateOrderRequest {

    private String username;

    private Long productCode;

    private int orderQuantity;


}
