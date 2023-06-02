package com.example.users.domain.services;

import com.example.users.domain.dto.UserDto;
import com.example.users.domain.model.User;
import com.example.users.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Converter convertir;

    @Override
    public List<UserDto> findAll() {
        List<Object[]> usersDto = null;
        usersDto = userRepository.findAllUsers();

        List<UserDto> userDtoList = usersDto.stream().map(user -> {
            UserDto userDto = new UserDto();
            userDto.setId((Long) (user[0]));
            userDto.setPhone(Objects.toString(user[1]));
            userDto.setLastName(Objects.toString(user[2]));
            userDto.setName(Objects.toString(user[3]));
            userDto.setEmail(Objects.toString(user[4]));
            userDto.setJobTitle(Objects.toString(user[5]));
            userDto.setToken(Objects.toString(user[6]));
            return userDto;
        }).toList();
        for (UserDto userDto : userDtoList) {
            LOGGER.info("UserDto: {}", userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto findById(Long id) {
    User user = userRepository.findById(id).orElse(null);
        return convertir.toDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setPhone(userDto.getPhone());
            user.setLastName(userDto.getLastName());
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setJobTitle(userDto.getJobTitle());
            user.setToken(userDto.getToken());
            userRepository.save(user);
            return convertir.toDto(user);
        }
        return null;
    }
}
