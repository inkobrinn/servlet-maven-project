package com.example.servlet.project.mapper;

import com.example.servlet.project.dto.CreateUserDto;
import com.example.servlet.project.entity.Gender;
import com.example.servlet.project.entity.User;
import com.example.servlet.project.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserMapper implements Mapper<CreateUserDto, User> {
    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .surname(object.getSurname())
                .phone(object.getPhone())
                .email(object.getEmail())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .build();
    }

    public static CreateUserMapper getInstance() {
        return INSTANCE;
    }
}
