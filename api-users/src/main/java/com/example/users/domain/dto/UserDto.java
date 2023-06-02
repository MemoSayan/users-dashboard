package com.example.users.domain.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDto  {
    private Long id;
    private String phone;
    private String name;

    private String lastName;

    private String email;

    private String jobTitle;

    private String token;

}
