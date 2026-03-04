package com.ilyassan.mediahub.media.mapper;

import com.ilyassan.mediahub.media.dto.MediaDto;
import com.ilyassan.mediahub.media.dto.MediaRequestDTO;
import com.ilyassan.mediahub.media.dto.MediaUpdateDTO;
import com.ilyassan.mediahub.media.entity.Media;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MediaMapper {
    MediaDto toDto(Media media);
    Media toEntity(MediaRequestDTO dto);
    void updateEntityFromDto(MediaUpdateDTO dto, @MappingTarget Media media);
}
