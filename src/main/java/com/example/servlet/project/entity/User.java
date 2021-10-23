package com.example.servlet.project.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private LocalDate birthday;
    private String password;
    private Role role;
    private Gender gender;
    private String image;
}
