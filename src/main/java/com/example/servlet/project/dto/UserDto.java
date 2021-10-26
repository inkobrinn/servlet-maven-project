package com.example.servlet.project.dto;

import com.example.servlet.project.entity.Gender;
import com.example.servlet.project.entity.Role;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class UserDto {
    Long id;
    String name;
    String surname;
    String email;
    LocalDate birthday;
    Role role;
    Gender gender;
    String image;
}
