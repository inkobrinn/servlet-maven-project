package com.example.servlet.project.mapper;

import com.example.servlet.project.dto.UserDto;
import com.example.servlet.project.entity.User;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserMapper implements Mapper<User, UserDto> {
    private static final UserMapper INSTANCE = new UserMapper();

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .name(object.getName())
                .surname(object.getSurname())
                .email(object.getEmail())
                .birthday(object.getBirthday())
                .role(object.getRole())
                .gender(object.getGender())
                .image(object.getImage())
                .build();
    }

    public static UserMapper getInstance() {
        return INSTANCE;
    }
}
