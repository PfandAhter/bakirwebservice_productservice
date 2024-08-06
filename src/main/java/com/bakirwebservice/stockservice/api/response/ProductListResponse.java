package com.bakirwebservice.stockservice.api.response;


import com.bakirwebservice.stockservice.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductListResponse {

    private List<ProductDTO> productList;
}
