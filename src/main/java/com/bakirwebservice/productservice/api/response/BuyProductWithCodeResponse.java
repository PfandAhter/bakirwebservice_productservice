package com.bakirwebservice.productservice.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BuyProductWithCodeResponse extends BaseResponse{

    private Long trackingNumber;

}