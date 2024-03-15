package com.bakirwebservice.productservice.rest.validator;

import com.bakirwebservice.productservice.model.entity.ErrorCodes;
import com.bakirwebservice.productservice.repository.ErrorCodeRepository;
import com.bakirwebservice.productservice.rest.validator.annotations.USETHATWHILEADDINGNEWPRODUCT;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueErrorValidator implements ConstraintValidator<USETHATWHILEADDINGNEWPRODUCT, String> {


    private final ErrorCodeRepository errorCodeRepository;

    @Override
    public boolean isValid(String error, ConstraintValidatorContext constraintValidatorContext) {
        ErrorCodes errorCodes = errorCodeRepository.findErrorByError(error);
        return errorCodes == null;
    }
}
