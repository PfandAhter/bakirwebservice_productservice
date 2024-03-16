package com.bakirwebservice.productservice.rest.controller.api;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.CreateOrderWithProductCodeRequest;
import com.bakirwebservice.productservice.api.request.GetCategoryListRequest;
import com.bakirwebservice.productservice.api.request.GetProductDetailsRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.constants.PropertyConstants;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductRestServiceApi {
    @PostMapping(PropertyConstants.PRODUCT_LIST)
    ResponseEntity<List<ProductDTO>> productListResponse(@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request);

    @PostMapping(PropertyConstants.PRODUCT_LIST_BY_NAME)
    ResponseEntity<List<ProductDTO>> categoryListByCategoryName(@Valid @RequestBody GetCategoryListRequest getCategoryListRequest, HttpServletRequest request);

    @PostMapping(PropertyConstants.REQUEST_PRODUCT_CREATE_ORDER_WITH_PRODUCT_CODE)
    ResponseEntity<BaseResponse> buyProductWithProductCode(@Valid @RequestBody CreateOrderWithProductCodeRequest createOrderWithProductCodeRequest, HttpServletRequest request);

    @PostMapping(PropertyConstants.REQUEST_PRODCUT_DETAILS)
    ResponseEntity<GetProductDetailsResponse> getProductInfo(@Valid @RequestBody GetProductDetailsRequest getProductDetailsRequest, HttpServletRequest request);


}
