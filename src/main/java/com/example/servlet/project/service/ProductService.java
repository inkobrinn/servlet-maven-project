package com.example.servlet.project.service;

import com.example.servlet.project.dao.ProductDao;
import com.example.servlet.project.dto.ProductDto;
import com.example.servlet.project.mapper.ProductMapper;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductService {
    private static final ProductService INSTANCE = new ProductService();
    private final ProductDao productDao = ProductDao.getInstance();
    private final ProductMapper productMapper = ProductMapper.getInstance();


    public static ProductService getInstance() {
        return INSTANCE;
    }

    public List<ProductDto> findByCategoryId(Integer categoryId) {
        return productDao.findByCategoryId(categoryId).stream().map(productMapper::mapFrom).collect(Collectors.toList());
    }


}
