package com.roberto.workloadtest.mapper;

import com.roberto.workloadtest.dto.user.RegisterUserRequest;
import com.roberto.workloadtest.dto.user.RegisterUserResponse;
import com.roberto.workloadtest.dto.user.UserResponse;
import com.roberto.workloadtest.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", expression = "java(password)")
    User fromRegisterRequest(RegisterUserRequest request, String password);

    RegisterUserResponse toRegisterResponse(User user);

    UserResponse toResponse(User user);
}
