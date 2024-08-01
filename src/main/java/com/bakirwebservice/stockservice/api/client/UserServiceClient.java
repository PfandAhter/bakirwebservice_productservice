package com.bakirwebservice.stockservice.api.client;

import com.bakirwebservice.stockservice.api.request.BaseRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "UserService" , url = "${client.feign.user-service.path}")
public interface UserServiceClient {

    @PostMapping("${client.feign.user-service.extractRoleFromToken}")
    String extractRoleFromToken (@RequestBody BaseRequest baseRequest);

    @PostMapping("${client.feign.user-service.extractSellerNameFromToken}")
    String extractSellerNameFromToken (@RequestBody BaseRequest baseRequest);
}
