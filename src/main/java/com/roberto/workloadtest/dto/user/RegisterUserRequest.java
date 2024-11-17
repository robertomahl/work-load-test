package com.roberto.workloadtest.dto.user;

import com.roberto.workloadtest.util.ValidationMessage;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterUserRequest(
        @NotBlank(message = "email" + ValidationMessage.MUST_BE_SPECIFIED)
        @Email(message = "email has incorrect format")
        String email,

        @NotBlank(message = "password" + ValidationMessage.MUST_BE_SPECIFIED)
        String password,

        @NotBlank(message = "passwordConfirm" + ValidationMessage.MUST_BE_SPECIFIED)
        String passwordConfirm,

        @NotBlank(message = "firstName" + ValidationMessage.MUST_BE_SPECIFIED)
        String firstName,

        @NotBlank(message = "lastName" + ValidationMessage.MUST_BE_SPECIFIED)
        String lastName
) {
};
