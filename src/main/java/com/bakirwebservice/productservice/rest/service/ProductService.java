package com.bakirwebservice.productservice.rest.service;


import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.CreateOrderWithProductCodeRequest;
import com.bakirwebservice.productservice.api.request.GetProductListRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> productListResponse (BaseRequest request);

    BaseResponse createOrder(CreateOrderWithProductCodeRequest request);

    GetProductDetailsResponse getProductInfoByProductCode(GetProductListRequest getProductListRequest);

}
