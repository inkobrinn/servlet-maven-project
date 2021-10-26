package com.example.servlet.project.service;

import com.example.servlet.project.dao.CategoryDao;
import com.example.servlet.project.dto.CategoryDto;
import com.example.servlet.project.mapper.CategoryMapper;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoryService {
    private static final CategoryService INSTANCE = new CategoryService();
    private final CategoryDao categoryDao = CategoryDao.getInstance();
    private final CategoryMapper categoryMapper = CategoryMapper.getInstance();

    public List<CategoryDto> findAll() {
        return categoryDao.findAll().stream().map(categoryMapper::mapFrom).collect(toList());
    }


    public static CategoryService getInstance() {
        return INSTANCE;
    }

}
