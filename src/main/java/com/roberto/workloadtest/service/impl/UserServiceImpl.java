package com.roberto.workloadtest.service.impl;

import com.roberto.workloadtest.dto.user.UserResponse;
import com.roberto.workloadtest.entity.User;
import com.roberto.workloadtest.mapper.UserMapper;
import com.roberto.workloadtest.repository.UserRepository;
import com.roberto.workloadtest.service.spec.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse getById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + userId));

        return UserMapper.INSTANCE.toResponse(user);
    }
}
