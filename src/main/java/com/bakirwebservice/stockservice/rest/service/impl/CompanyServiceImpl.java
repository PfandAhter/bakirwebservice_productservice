package com.bakirwebservice.stockservice.rest.service.impl;

import com.bakirwebservice.stockservice.api.client.UserServiceClient;
import com.bakirwebservice.stockservice.api.request.CompanyAddRequest;
import com.bakirwebservice.stockservice.api.response.BaseResponse;
import com.bakirwebservice.stockservice.model.entity.Company;
import com.bakirwebservice.stockservice.repository.CompanyRepository;
import com.bakirwebservice.stockservice.rest.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    private final UserServiceClient userServiceClient;

    public BaseResponse addCompany(CompanyAddRequest request){
        String localUserRole = userServiceClient.extractRoleFromToken(request);

        if(localUserRole.equals("ADMIN") || localUserRole.equals("SELLER")) {
            companyRepository.save(Company.builder().companyName(request.getCompanyName()).status(request.getStatus()).build());
            return new BaseResponse();
        }else{
            throw new org.springframework.security.access.AccessDeniedException("ACCESS DENIED");
        }
    }
}
