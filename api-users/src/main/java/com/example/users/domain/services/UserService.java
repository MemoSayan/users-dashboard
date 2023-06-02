package com.example.users.domain.services;

import com.example.users.domain.dto.UserDto;
import com.example.users.domain.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto updateUser(UserDto userDto, Long id);
}
