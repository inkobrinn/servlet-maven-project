package com.example.servlet.project.mapper;

import com.example.servlet.project.dto.ProductDto;
import com.example.servlet.project.entity.Product;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductMapper implements Mapper<Product, ProductDto> {
    private static final ProductMapper INSTANCE = new ProductMapper();

    @Override
    public ProductDto mapFrom(Product object) {
        return ProductDto.builder()
                .id(object.getId())
                .brand(object.getBrand())
                .name(object.getName())
                .categoryId(object.getCategoryId())
                .makerId(object.getMakerId())
                .price(object.getPrice())
                .build();
    }

    public static ProductMapper getInstance() {
        return INSTANCE;
    }
}
