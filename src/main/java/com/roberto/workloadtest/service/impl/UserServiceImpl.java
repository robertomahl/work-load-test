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
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user with id " + id));

        return UserMapper.INSTANCE.toResponse(user);
    }

    @Override
    public UserResponse getByEmail(String email) {
        User user = userRepository.findFirstByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user with email " + email));

        return UserMapper.INSTANCE.toResponse(user);
    }
}
