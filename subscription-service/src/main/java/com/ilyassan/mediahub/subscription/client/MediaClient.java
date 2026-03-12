package com.ilyassan.mediahub.subscription.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ilyassan.mediahub.subscription.dto.MediaDto;
import com.ilyassan.mediahub.subscription.dto.MediaResponseDto;

@FeignClient(name = "media-service")
public interface MediaClient {

    @GetMapping("/media/{id}")
    MediaResponseDto<MediaDto> getMediaById(@PathVariable Long id);
}
