package com.bakirwebservice.productservice.infra.impl;

import com.bakirwebservice.productservice.infra.HeaderService;
import com.bakirwebservice.productservice.model.CommonHeader;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Service
public class HeaderServiceImpl implements HeaderService {
    @Override
    public CommonHeader getHeader(HttpServletRequest request) {
        CommonHeader commonHeader = new CommonHeader();
        commonHeader.setToken(request.getHeader(AUTHORIZATION));
        return commonHeader;
    }
}
