package com.bakirwebservice.productservice.rest.service.interfaces;


import com.bakirwebservice.productservice.api.request.BaseRequest;
import com.bakirwebservice.productservice.api.request.CreateOrderWithProductCodeRequest;
import com.bakirwebservice.productservice.api.request.GetCategoryListRequest;
import com.bakirwebservice.productservice.api.request.GetProductDetailsRequest;
import com.bakirwebservice.productservice.api.response.BaseResponse;
import com.bakirwebservice.productservice.api.response.GetProductDetailsResponse;
import com.bakirwebservice.productservice.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    List<ProductDTO> productListResponse (BaseRequest request);

    List<ProductDTO> categoryListByCategoryName(GetCategoryListRequest request);

    BaseResponse createOrder(CreateOrderWithProductCodeRequest request);

    GetProductDetailsResponse getProductInfoByProductCode(GetProductDetailsRequest getProductDetailsRequest);

}
