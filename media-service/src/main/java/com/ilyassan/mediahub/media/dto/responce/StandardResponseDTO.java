package com.ilyassan.mediahub.media.dto.responce;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponseDTO<@NonNull T> {
    private LocalDateTime timestamp;
    private String message;
    private int status;
    private String path;
    private T data;
}
