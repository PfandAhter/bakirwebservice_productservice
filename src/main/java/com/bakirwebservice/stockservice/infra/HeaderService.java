package com.bakirwebservice.stockservice.infra;

import com.bakirwebservice.stockservice.model.CommonHeader;
import jakarta.servlet.http.HttpServletRequest;

public interface HeaderService {

    CommonHeader getHeader(HttpServletRequest request);
}
