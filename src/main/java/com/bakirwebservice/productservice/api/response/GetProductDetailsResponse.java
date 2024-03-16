package com.bakirwebservice.productservice.api.response;

import com.bakirwebservice.productservice.model.dto.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetProductDetailsResponse {

    private List<ProductDetails> productDetailsList;
}
