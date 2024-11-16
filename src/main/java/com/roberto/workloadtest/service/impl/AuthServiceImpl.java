package com.roberto.workloadtest.service.impl;

import com.roberto.workloadtest.dto.user.RegisterUserRequest;
import com.roberto.workloadtest.dto.user.RegisterUserResponse;
import com.roberto.workloadtest.entity.User;
import com.roberto.workloadtest.mapper.UserMapper;
import com.roberto.workloadtest.repository.UserRepository;
import com.roberto.workloadtest.service.spec.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterUserResponse signup(RegisterUserRequest request) {
        assertPasswordsMatch(request);

        User user = UserMapper.INSTANCE.fromRegisterRequest(request, passwordEncoder.encode(request.password()));

        return UserMapper.INSTANCE.toRegisterResponse(userRepository.save(user));
    }

    private void assertPasswordsMatch(RegisterUserRequest request) {
        if (!request.password().equals(request.passwordConfirm())) {
            throw new IllegalArgumentException("Passwords do not match.");
        }
    }
}
