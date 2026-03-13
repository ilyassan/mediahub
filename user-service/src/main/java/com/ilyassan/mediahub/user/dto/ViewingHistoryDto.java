package com.ilyassan.mediahub.user.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ViewingHistoryDto {
    private Long id;
    private Long userId;
    private Long mediaId;
    private LocalDateTime watchedAt;
}
