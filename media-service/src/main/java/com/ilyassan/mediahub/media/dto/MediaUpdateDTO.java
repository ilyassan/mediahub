package com.ilyassan.mediahub.media.dto;

import com.ilyassan.mediahub.media.enums.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MediaUpdateDTO {

    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @Size(min = 10, max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    private MediaType type;

    private String genre;

    private String category;
}
