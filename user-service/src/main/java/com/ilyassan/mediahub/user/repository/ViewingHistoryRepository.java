package com.ilyassan.mediahub.user.repository;

import com.ilyassan.mediahub.user.entity.ViewingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewingHistoryRepository extends JpaRepository<ViewingHistory, Long> {
    List<ViewingHistory> findByUserId(Long userId);
}
