package com.example.servlet.project.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CategoryDto {
    Integer id;
    String name;
}
