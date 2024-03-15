package com.bakirwebservice.productservice.api.response;

import com.bakirwebservice.productservice.model.dto.ProductDetails;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class GetProductDetailsResponse {

    List<ProductDetails> productDetailsList;
}
