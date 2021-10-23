package com.example.servlet.project.mapper;

public interface Mapper<F, T> {

    T mapFrom(F object);
}
