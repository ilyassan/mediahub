package com.ilyassan.mediahub.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "viewing_history")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Store only IDs — no JPA relations across services (microservices own their own DBs)
    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long mediaId;

    @Column(nullable = false)
    private LocalDateTime watchedAt;

    @PrePersist
    public void prePersist() {
        if (watchedAt == null) {
            watchedAt = LocalDateTime.now();
        }
    }
}
