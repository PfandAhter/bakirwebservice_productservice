package com.bakirwebservice.stockservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateRequest extends ProductAddRequest {

    private String productId;
}
