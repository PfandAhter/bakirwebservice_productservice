package com.bakirwebservice.productservice.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class GetProductDetailsRequest {

    private List<Long> productCodeList;
}
