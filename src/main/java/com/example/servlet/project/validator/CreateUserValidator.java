package com.example.servlet.project.validator;

import com.example.servlet.project.dto.CreateUserDto;
import com.example.servlet.project.entity.Gender;
import com.example.servlet.project.util.LocalDateFormatter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CreateUserValidator implements Validator<CreateUserDto> {
    private static final CreateUserValidator INSTANCE = new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())) {
            validationResult.add(Error.of("invalid birthday", "Birthday is invalid"));
        }
        if (object.getGender() == null || Gender.find(object.getGender()) == null) {
            validationResult.add(Error.of("invalid gender", "Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance() {
        return INSTANCE;
    }
}
