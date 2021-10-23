package com.example.servlet.project.service;

import com.example.servlet.project.dao.UserDao;
import com.example.servlet.project.dto.CreateUserDto;
import com.example.servlet.project.entity.User;
import com.example.servlet.project.exception.ValidationException;
import com.example.servlet.project.mapper.CreateUserMapper;
import com.example.servlet.project.validator.CreateUserValidator;
import com.example.servlet.project.validator.ValidationResult;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {
    private static final UserService INSTANCE = new UserService();
    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Long create(CreateUserDto clientDto) {
        ValidationResult validationResult = createUserValidator.isValid(clientDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrorList());
        }
        User user = createUserMapper.mapFrom(clientDto);
        userDao.save(user);
        return user.getId();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
