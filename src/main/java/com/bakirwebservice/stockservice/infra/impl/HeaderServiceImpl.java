package com.bakirwebservice.stockservice.infra.impl;

import com.bakirwebservice.stockservice.infra.HeaderService;
import com.bakirwebservice.stockservice.model.CommonHeader;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
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


    //TODO testing...
    public CommonHeader getHeader(ServerHttpRequest request) {
        CommonHeader commonHeader = new CommonHeader();
        request.getHeaders().containsKey("ROLE");
        return commonHeader;
    }

}
