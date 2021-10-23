package com.example.servlet.project.dto;

import lombok.Builder;
import lombok.Value;

import javax.servlet.http.Part;

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
    Part image;
}
