package com.example.servlet.project.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
