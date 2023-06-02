package com.example.users.domain.services;

import com.example.users.domain.dto.UserDto;
import com.example.users.domain.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    User user;

    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public User toEntity(UserDto user) {
        if (user == null) {
            return null;
        }
        User entity = new User();
        BeanUtils.copyProperties(user, entity);
        return entity;
    }

    public List<UserDto> toDtoList(List<User> user) {
        if (user == null) {
            return null;
        }
        List<UserDto> list = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            User userEt = user.get(i);
            UserDto userDto = toDto(userEt);
            list.add(userDto);
        }
        return list;
    }
}
