package com.ilyassan.mediahub.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ViewingHistoryRequest {

    @NotNull(message = "mediaId is required")
    private Long mediaId;
}
