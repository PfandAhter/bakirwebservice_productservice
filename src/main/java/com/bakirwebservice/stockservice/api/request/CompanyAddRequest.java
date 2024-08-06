package com.bakirwebservice.stockservice.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CompanyAddRequest extends BaseRequest{
    private String companyName;
    private String status;
}
