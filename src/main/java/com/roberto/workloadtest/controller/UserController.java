package com.roberto.workloadtest.controller;

import com.roberto.workloadtest.dto.user.UserResponse;
import com.roberto.workloadtest.service.spec.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    @Operation(summary = "Get user by id", description = "Get details of the user by id.")
    public ResponseEntity<UserResponse> getById(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userId));
    }

    @GetMapping
    @Operation(summary = "Get user by email", description = "Get details of the user by email.")
    public ResponseEntity<UserResponse> getByEmail(@Param("email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getByEmail(email));
    }

}
