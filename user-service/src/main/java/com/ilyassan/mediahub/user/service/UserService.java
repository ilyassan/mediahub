package com.ilyassan.mediahub.user.service;

import com.ilyassan.mediahub.user.client.SubscriptionClient;
import com.ilyassan.mediahub.user.dto.SubscriptionDto;
import com.ilyassan.mediahub.user.dto.UserDto;
import com.ilyassan.mediahub.user.dto.UserRequest;
import com.ilyassan.mediahub.user.dto.ViewingHistoryDto;
import com.ilyassan.mediahub.user.dto.ViewingHistoryRequest;
import com.ilyassan.mediahub.user.entity.User;
import com.ilyassan.mediahub.user.entity.ViewingHistory;
import com.ilyassan.mediahub.user.repository.UserRepository;
import com.ilyassan.mediahub.user.repository.ViewingHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ViewingHistoryRepository viewingHistoryRepository;
    private final SubscriptionClient subscriptionClient;
    private final WebClient webClient;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return toDto(user);
    }

    public UserDto updateUser(Long id, UserRequest request) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        existing.setName(request.getName());
        existing.setEmail(request.getEmail());
        existing.setRole(request.getRole());

        return toDto(userRepository.save(existing));
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    public UserDto createUser(UserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .role(request.getRole())
                .build();
        return toDto(userRepository.save(user));
    }

    public SubscriptionDto getUserSubscription(Long userId) {
        return subscriptionClient.getSubscriptionByUserId(userId);
    }

    public List<?> getAvailableMedia() {
        return webClient
                .get()
                .uri("http://media-service/media")
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList()
                .block();
    }

    public ViewingHistoryDto addToHistory(Long userId, ViewingHistoryRequest request) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        ViewingHistory history = ViewingHistory.builder()
                .userId(userId)
                .mediaId(request.getMediaId())
                .build();
        return toHistoryDto(viewingHistoryRepository.save(history));
    }

    public List<ViewingHistoryDto> getViewingHistory(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        return viewingHistoryRepository.findByUserId(userId)
                .stream()
                .map(this::toHistoryDto)
                .toList();
    }

    private ViewingHistoryDto toHistoryDto(ViewingHistory h) {
        return ViewingHistoryDto.builder()
                .id(h.getId())
                .userId(h.getUserId())
                .mediaId(h.getMediaId())
                .watchedAt(h.getWatchedAt())
                .build();
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
