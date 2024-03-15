package com.bakirwebservice.productservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor

public class ErrorCodesDTO {

    private String error;

    private Long errorCode;

    private String errorDescription;
}
