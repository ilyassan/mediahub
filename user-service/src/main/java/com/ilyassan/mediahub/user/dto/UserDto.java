package com.ilyassan.mediahub.user.dto;

import com.ilyassan.mediahub.user.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Role role;
}
