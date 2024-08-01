package com.bakirwebservice.stockservice.api.response;

import com.bakirwebservice.stockservice.model.dto.ProductDTO;
import com.bakirwebservice.stockservice.model.dto.ProductGetDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductGetResponse {
    private ProductGetDTO productInfo;
}
