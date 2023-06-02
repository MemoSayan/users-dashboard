package com.example.users.application.controller;

import com.example.users.domain.dto.UserDto;
import com.example.users.domain.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/api/v1")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDto> index() {
        List<UserDto> usersList = userService.findAll();
        return usersList;
    }

    @GetMapping("/user/{id}")
    public UserDto singleUserDto(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping("/user/{id}")
    public UserDto updateUserDto(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userService.updateUser(userDto, id);
    }

   /* @PostMapping("/user")
    public UserDto createUserDto(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    } */

}
