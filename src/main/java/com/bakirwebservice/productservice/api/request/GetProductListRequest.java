package com.bakirwebservice.productservice.api.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class GetProductListRequest {

    private List<Long> productCodeList;
}
