package com.bakirwebservice.stockservice.rest.validator;

import com.bakirwebservice.stockservice.model.entity.ErrorCodes;
import com.bakirwebservice.stockservice.repository.ErrorCodeRepository;
import com.bakirwebservice.stockservice.rest.validator.annotations.USETHATWHILEADDINGNEWPRODUCT;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueErrorValidator implements ConstraintValidator<USETHATWHILEADDINGNEWPRODUCT, String> {


    private final ErrorCodeRepository errorCodeRepository;

    @Override
    public boolean isValid(String error, ConstraintValidatorContext constraintValidatorContext) {
        ErrorCodes errorCodes = errorCodeRepository.findErrorByErrorCode(error);
        return errorCodes == null;
    }
}
