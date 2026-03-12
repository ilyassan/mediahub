package com.ilyassan.mediahub.subscription.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MediaResponseDto<T> {

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private String path;
    private T data;
}
