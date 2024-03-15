package com.bakirwebservice.productservice.rest.controller.api;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.CreateOrderWithProductCodeRequest;
import com.bakirwebservice.productservice.api.request.GetCategoryListRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.constants.PropertyConstants;
import com.bakirwebservice.productservice.model.dto.OrderListDTO;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public interface ProductRestServiceApi {
    @PostMapping(path = PropertyConstants.PRODUCT_LIST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> productListResponse (@Valid @RequestBody BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.PRODUCT_LIST_BY_NAME ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ProductDTO>> categoryListByCategoryName(@Valid @RequestBody GetCategoryListRequest getCategoryListRequest , HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_PRODUCT_CREATE_ORDER_WITH_PRODUCT_CODE,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BaseResponse> buyProductWithProductCode(@Valid @RequestBody CreateOrderWithProductCodeRequest createOrderWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult);

    @PostMapping(path = PropertyConstants.REQUEST_PRODCUT_DETAILS)
    ResponseEntity<GetProductDetailsResponse> getProductInfo (@Valid @RequestBody ArrayList<OrderListDTO> orderListDTOArrayList);


}
