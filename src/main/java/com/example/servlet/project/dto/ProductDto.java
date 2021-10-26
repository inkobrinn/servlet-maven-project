package com.example.servlet.project.dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class ProductDto {
    Long id;
    String brand;
    String name;
    Integer categoryId;
    Integer makerId;
    BigDecimal price;
}
