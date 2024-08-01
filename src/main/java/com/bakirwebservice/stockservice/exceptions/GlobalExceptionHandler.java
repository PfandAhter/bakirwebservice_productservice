package com.bakirwebservice.stockservice.exceptions;

import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.infra.MapperService;
import com.bakirwebservice.stockservice.lib.constants.ErrorCodeConstants;
import com.bakirwebservice.stockservice.model.dto.ErrorCodesDTO;
import com.bakirwebservice.stockservice.model.entity.ErrorCodes;
import com.bakirwebservice.stockservice.repository.ErrorCodeRepository;
import jakarta.security.auth.message.AuthException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

import static com.bakirwebservice.stockservice.lib.constants.ResponseStatus.FAILED;


@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    private final ErrorCodeRepository errorCodeRepository;

    private final MapperService mapperService;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BaseResponse> handleException(RuntimeException e) {
        log.error("Error: ", e);
        return ResponseEntity.internalServerError().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<BaseResponse> handleException(ResourceAccessException e) {
        log.error("Error : " + e.getMessage());
        return ResponseEntity.badRequest().body(createFailResponse(ErrorCodeConstants.SERVICE_UNAVAILABLE));
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<BaseResponse> handleException(OutOfStockException e){
        log.error("Error : " + e.getMessage());
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> handleException(AccessDeniedException e){
        log.error("Error : " + e.getMessage());
        return ResponseEntity.badRequest().body(createFailResponse("ACCESS DENIED"));
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<BaseResponse> handleException(AuthException e) {
        return ResponseEntity.badRequest().body(createFailResponse(e.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(createFailResponse(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage()));
    }

    private BaseResponse createFailResponse(String errorKey) {
        ErrorCodesDTO errorCodesDTO = findErrorCode(errorKey);
        return new BaseResponse(FAILED, errorCodesDTO.getErrorCode(), errorCodesDTO.getErrorDescription());
    }

    private ErrorCodesDTO findErrorCode(String errorKey) {
        ErrorCodes errorCodes = errorCodeRepository.findErrorByErrorCode(errorKey);
        if (errorCodes == null) {
            errorCodes = new ErrorCodes();
            errorCodes.setErrorCode(errorKey);
            errorCodes.setErrorDescription(errorKey);
        }
        return mapperService.map(errorCodes, ErrorCodesDTO.class);
    }
}

