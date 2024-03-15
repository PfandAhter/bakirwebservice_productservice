package com.bakirwebservice.productservice.exceptions;

import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.model.constants.ErrorCodeConstants;
import jakarta.security.auth.message.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import static com.bakirwebservice.productservice.model.constants.Constants.FAILED;


@RestControllerAdvice
@Slf4j

public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleException(RuntimeException e) {
        log.error("Error: ",e);
        return ResponseEntity.internalServerError().body(createFailResponse(e.getMessage()));

    }
    @ExceptionHandler(java.lang.IllegalArgumentException.class)
    public ResponseEntity<BaseResponse> handleException(java.lang.IllegalArgumentException e){
        log.error("Error: ",e);
//        log.info("hata bu : " + e.getClass().getName() + " ,, @@ aciklamasi ise :"  + e.getMessage());

        return ResponseEntity.internalServerError().body(createFailResponse("GECERSIZ IFADE"));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<BaseResponse> handleException(ResourceAccessException e){
        log.error("Error : " + e.getMessage());
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<BaseResponse> handleException(AuthException e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleException(Exception e) {

        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    private BaseResponse createFailResponse(String errorDescription) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setErrorCode(FAILED);
        baseResponse.setErrorDescription(errorDescription);
        return baseResponse;
    }
}

