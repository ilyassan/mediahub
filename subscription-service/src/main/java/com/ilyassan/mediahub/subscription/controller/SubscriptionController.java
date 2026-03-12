package com.ilyassan.mediahub.subscription.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilyassan.mediahub.subscription.dto.MediaDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionRequest;
import com.ilyassan.mediahub.subscription.service.SubscriptionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<SubscriptionDto> createSubscription(@Valid @RequestBody SubscriptionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subscriptionService.createSubscription(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<SubscriptionDto> getSubscriptionByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getSubscriptionByUserId(userId));
    }

    @GetMapping("/media/{mediaId}")
    public ResponseEntity<MediaDto> getMediaDetails(@PathVariable Long mediaId) {
        return ResponseEntity.ok(subscriptionService.getMediaDetails(mediaId));
    }
}
