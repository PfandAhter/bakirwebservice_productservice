package com.bakirwebservice.stockservice.api.client;

import com.bakirwebservice.stockservice.api.request.UserOrderedProductRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "PaymentService" , url = "${client.feign.payment-service.path}")
public interface PaymentServiceClient {

    @PostMapping("${client.feign.payment-service.userOrderedProduct}")
    Boolean userHasOrder (@RequestBody UserOrderedProductRequest userOrderedProductRequest);

}
