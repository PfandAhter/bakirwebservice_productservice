package com.bakirwebservice.stockservice.api;

import com.bakirwebservice.stockservice.api.request.CompanyAddRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("company")
public interface CompanyApi {

    @PostMapping("add")
    ResponseEntity<BaseResponse> addCompany(@RequestBody @Valid CompanyAddRequest companyAddRequest, HttpServletRequest request);
}
