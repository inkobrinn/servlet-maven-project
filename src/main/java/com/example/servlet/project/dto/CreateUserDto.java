package com.example.servlet.project.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateUserDto {

    String name;
    String surname;
    String phone;
    String email;
    String birthday;
    String password;
    String gender;
}
