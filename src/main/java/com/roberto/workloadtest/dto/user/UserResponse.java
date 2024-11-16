package com.roberto.workloadtest.dto.user;

import java.time.LocalDateTime;

public record UserResponse(

        Long id,

        String email,

        String firstName,

        String lastName,

        LocalDateTime createdAt,

        LocalDateTime updatedAt
) {

}
