package com.bakirwebservice.productservice.api;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("product")
public interface ProductApi {
    @PostMapping("list")
    ResponseEntity<List<ProductDTO>> productListResponse(@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request);

}
