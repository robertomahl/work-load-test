package com.roberto.workloadtest.controller;

import com.roberto.workloadtest.dto.user.RegisterUserRequest;
import com.roberto.workloadtest.dto.user.RegisterUserResponse;
import com.roberto.workloadtest.service.spec.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Auth Controller")
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @Operation(summary = "Create a new user", description = "Creates a new user in the system.")
    public ResponseEntity<RegisterUserResponse> register(@Valid @RequestBody RegisterUserRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

}
