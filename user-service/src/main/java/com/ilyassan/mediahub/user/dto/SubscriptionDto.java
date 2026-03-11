package com.ilyassan.mediahub.user.dto;

import lombok.Data;

@Data
public class SubscriptionDto {
    private Long id;
    private Long userId;
    private String plan;
    private String status;
    private String startDate;
    private String endDate;
}
