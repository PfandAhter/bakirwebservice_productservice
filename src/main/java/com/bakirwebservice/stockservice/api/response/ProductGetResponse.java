package com.bakirwebservice.stockservice.api.response;

import com.bakirwebservice.stockservice.model.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductGetResponse {
    private ProductDTO productDTO;
}
