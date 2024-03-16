package com.bakirwebservice.productservice.infra;

import com.bakirwebservice.productservice.model.CommonHeader;
import jakarta.servlet.http.HttpServletRequest;

public interface HeaderService {

    CommonHeader getHeader(HttpServletRequest request);
}
