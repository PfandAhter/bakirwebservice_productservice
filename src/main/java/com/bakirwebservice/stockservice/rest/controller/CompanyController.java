package com.bakirwebservice.stockservice.rest.controller;

import com.bakirwebservice.stockservice.api.CompanyApi;
import com.bakirwebservice.stockservice.api.request.CompanyAddRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.rest.service.impl.CompanyServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CompanyController implements CompanyApi {

    private final CompanyServiceImpl companyService;

    @Override
    public ResponseEntity<BaseResponse> addCompany(CompanyAddRequest companyAddRequest, HttpServletRequest request) {
        return ResponseEntity.ok(companyService.addCompany(companyAddRequest));
    }
}
