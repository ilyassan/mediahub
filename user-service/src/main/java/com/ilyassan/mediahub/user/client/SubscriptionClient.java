package com.ilyassan.mediahub.user.client;

import com.ilyassan.mediahub.user.dto.SubscriptionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subscription-service")
public interface SubscriptionClient {

    @GetMapping("/subscriptions/user/{userId}")
    SubscriptionDto getSubscriptionByUserId(@PathVariable Long userId);
}
