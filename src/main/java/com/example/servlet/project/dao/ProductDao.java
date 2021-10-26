package com.example.servlet.project.dao;

import com.example.servlet.project.entity.Product;
import com.example.servlet.project.util.ConnectionManager;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ProductDao implements Dao<Long, Product> {
    private static final ProductDao INSTANCE = new ProductDao();
    private static final String FIND_ALL_BY_MAKER_ID = "SELECT " +
            "id," +
            " brand," +
            " name," +
            " category_id," +
            " maker_id," +
            " price" +
            " FROM product WHERE category_id = ?";


    public List<Product> findByCategoryId(Integer categoryId) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_MAKER_ID);
            preparedStatement.setInt(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(Product.builder()
                        .id(resultSet.getLong("id"))
                        .brand(resultSet.getString("brand"))
                        .name(resultSet.getString("name"))
                        .categoryId(resultSet.getInt("category_id"))
                        .makerId(resultSet.getInt("maker_id"))
                        .price(resultSet.getBigDecimal("price"))
                        .build());
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
