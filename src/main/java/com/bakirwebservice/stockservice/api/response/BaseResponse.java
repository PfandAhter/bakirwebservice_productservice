package com.bakirwebservice.stockservice.api.response;

import com.bakirwebservice.stockservice.lib.constants.Constants;
import com.bakirwebservice.stockservice.lib.constants.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({
        "Statu",
        "HataKodu",
        "HataMesaji"
})
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    @JsonProperty("Statu")
    private String status = ResponseStatus.SUCCESS;

    @JsonProperty("HataKodu")
    private String errorCode = Constants.SUCCESS;

    @JsonProperty("HataMesaji")
    private String errorDescription = Constants.SUCCESS;
}