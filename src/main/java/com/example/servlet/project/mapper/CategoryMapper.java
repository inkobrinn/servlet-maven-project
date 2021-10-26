package com.example.servlet.project.mapper;

import com.example.servlet.project.dto.CategoryDto;
import com.example.servlet.project.entity.Category;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CategoryMapper implements Mapper<Category, CategoryDto> {
    private static final CategoryMapper INSTANCE = new CategoryMapper();

    @Override
    public CategoryDto mapFrom(Category object) {
        return CategoryDto.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }

    public static CategoryMapper getInstance() {
        return INSTANCE;
    }
}
