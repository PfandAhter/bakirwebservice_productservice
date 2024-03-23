package com.bakirwebservice.stockservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructor

public class ErrorCodesDTO {

    private String error;

    private String errorCode;

    private String errorDescription;
}
