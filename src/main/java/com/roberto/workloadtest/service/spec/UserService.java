package com.roberto.workloadtest.service.spec;

import com.roberto.workloadtest.dto.user.UserResponse;

public interface UserService {

    UserResponse getById(Long id);
    UserResponse getByEmail(String email);

}
