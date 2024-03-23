package com.bakirwebservice.stockservice.repository;

import com.bakirwebservice.stockservice.model.entity.ErrorCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCodes,Long> {

    ErrorCodes findErrorByErrorCode(String errorCode);


}
