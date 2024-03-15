package com.bakirwebservice.productservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BoughtProductReduceBalanceRequest {
    private String customerName;

    private String productId;

    private int orderQuantity;
}
