package com.ilyassan.mediahub.media.service.interfaces;

import com.ilyassan.mediahub.media.dto.MediaRequestDTO;
import com.ilyassan.mediahub.media.dto.MediaUpdateDTO;
import com.ilyassan.mediahub.media.dto.responce.PaginationDTO;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Pageable;

public interface MediaService {
    MediaRequestDTO create(@NonNull MediaRequestDTO dto);
    MediaRequestDTO update(@NonNull Long id, @NonNull MediaUpdateDTO dto);
    PaginationDTO getAll(String genre, String category, @NonNull Pageable pageable);
    Void delete(@NonNull Long id);

}
