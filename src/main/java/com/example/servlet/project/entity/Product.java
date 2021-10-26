package com.example.servlet.project.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class Product {
    private Long id;
    private String brand;
    private String name;
    private Integer categoryId;
    private Integer makerId;
    private BigDecimal price;
}
