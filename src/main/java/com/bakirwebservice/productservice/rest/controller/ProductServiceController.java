package com.bakirwebservice.productservice.rest.controller;

import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.CreateOrderWithProductCodeRequest;
import com.bakirwebservice.productservice.api.request.GetCategoryListRequest;
import com.bakirwebservice.productservice.api.request.GetProductDetailsRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.constants.PropertyConstants;
import com.bakirwebservice.productservice.model.dto.OrderListDTO;
import com.bakirwebservice.productservice.model.dto.ProductDTO;
import com.bakirwebservice.productservice.rest.controller.api.ProductRestServiceApi;
import com.bakirwebservice.productservice.rest.service.ProductServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(path = PropertyConstants.REQUEST_PRODUCTSERVICE) // /productservice/product
@Controller
@CrossOrigin
@Slf4j
@RequiredArgsConstructor

public class ProductServiceController implements ProductRestServiceApi {

    private final ProductServiceImpl productService;

    @Override
    public ResponseEntity<List<ProductDTO>> productListResponse(BaseRequest baseRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(productService.productListResponse(baseRequest));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> categoryListByCategoryName(GetCategoryListRequest getCategoryListRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(productService.categoryListByCategoryName(getCategoryListRequest));
    }

    @Override
    public ResponseEntity<BaseResponse> buyProductWithProductCode(CreateOrderWithProductCodeRequest createOrderWithProductCodeRequest, HttpServletRequest request, BindingResult bindingResult) {
        return ResponseEntity.ok(productService.createOrder(createOrderWithProductCodeRequest));
    }

    @Override
    public ResponseEntity<GetProductDetailsResponse> getProductInfo(ArrayList<OrderListDTO> orderListDTOArrayList) {
        return ResponseEntity.ok(productService.getProductInfoByProductCode(orderListDTOArrayList));
    }

}
