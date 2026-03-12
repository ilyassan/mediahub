package com.ilyassan.mediahub.subscription.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.ilyassan.mediahub.subscription.client.MediaClient;
import com.ilyassan.mediahub.subscription.dto.MediaDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionDto;
import com.ilyassan.mediahub.subscription.dto.SubscriptionRequest;
import com.ilyassan.mediahub.subscription.entity.Subscription;
import com.ilyassan.mediahub.subscription.enums.SubscriptionStatus;
import com.ilyassan.mediahub.subscription.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final MediaClient mediaClient;

    public SubscriptionDto createSubscription(SubscriptionRequest request) {
        Subscription subscription = Subscription.builder()
                .userId(request.getUserId())
                .plan(request.getPlan())
                .status(SubscriptionStatus.ACTIVE)
                .startDate(request.getStartDate() != null ? request.getStartDate() : LocalDate.now())
                .endDate(request.getEndDate())
                .build();
        return toDto(subscriptionRepository.save(subscription));
    }

    public SubscriptionDto getSubscriptionByUserId(Long userId) {
        Subscription subscription = subscriptionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("No subscription found for user: " + userId));
        return toDto(subscription);
    }

    public MediaDto getMediaDetails(Long mediaId) {
        return mediaClient.getMediaById(mediaId).getData();
    }

    private SubscriptionDto toDto(Subscription s) {
        return SubscriptionDto.builder()
                .id(s.getId())
                .userId(s.getUserId())
                .plan(s.getPlan())
                .status(s.getStatus())
                .startDate(s.getStartDate())
                .endDate(s.getEndDate())
                .build();
    }
}
