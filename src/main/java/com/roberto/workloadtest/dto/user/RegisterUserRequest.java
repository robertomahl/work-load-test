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
        @Pattern(message = "password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit", regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}")
        String password,

        @NotBlank(message = "passwordConfirm" + ValidationMessage.MUST_BE_SPECIFIED)
        @Pattern(message = "passwordConfirm must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit", regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}")
        String passwordConfirm,

        @NotBlank(message = "firstName" + ValidationMessage.MUST_BE_SPECIFIED)
        String firstName,

        @NotBlank(message = "lastName" + ValidationMessage.MUST_BE_SPECIFIED)
        String lastName
) {
};
