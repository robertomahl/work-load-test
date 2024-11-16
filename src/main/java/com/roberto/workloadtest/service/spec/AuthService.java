package com.roberto.workloadtest.service.spec;

import com.roberto.workloadtest.dto.user.RegisterUserRequest;
import com.roberto.workloadtest.dto.user.RegisterUserResponse;

public interface AuthService {

    RegisterUserResponse signup(RegisterUserRequest request);

}
