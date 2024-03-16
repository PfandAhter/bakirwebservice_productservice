package com.bakirwebservice.productservice.rest.controller;

import com.bakirwebservice.productservice.api.ProductApi;
import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import com.bakirwebservice.productservice.rest.service.impl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

 // /productservice/product
@Controller
@CrossOrigin
@Slf4j
@RequiredArgsConstructor

public class ProductController implements ProductApi {

    private final ProductServiceImpl productService;

    @Override
    public ResponseEntity<List<ProductDTO>> productListResponse(BaseRequest baseRequest, HttpServletRequest request) {
        return ResponseEntity.ok(productService.productListResponse(baseRequest));
    }

//    @Override
//    public ResponseEntity<List<ProductDTO>> categoryListByCategoryName(GetCategoryListRequest getCategoryListRequest, HttpServletRequest request) {
//        return ResponseEntity.ok(productService.categoryListByCategoryName(getCategoryListRequest));
//    }
//
//    @Override
//    public ResponseEntity<BaseResponse> buyProductWithProductCode(CreateOrderWithProductCodeRequest createOrderWithProductCodeRequest, HttpServletRequest request) {
//        return ResponseEntity.ok(productService.createOrder(createOrderWithProductCodeRequest));
//    }
//
//    @Override
//    public ResponseEntity<GetProductDetailsResponse> getProductInfo(GetProductListRequest getProductListRequest, HttpServletRequest request) {
//        return ResponseEntity.ok(productService.getProductInfoByProductCode(getProductListRequest));
//    }

}
