package com.example.servlet.project.dao;

import com.example.servlet.project.entity.Category;
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
public class CategoryDao implements Dao<Integer, Category> {
    private static final CategoryDao INSTANCE = new CategoryDao();
    private static final String FIND_ALL = "SELECT id, name FROM category";


    @Override
    public List<Category> findAll() {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Category> listCategory = new ArrayList<>();
            while (resultSet.next()) {
                listCategory.add(
                        getBuild(resultSet));
            }
            return listCategory;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(Category entity) {

    }

    @Override
    public Category save(Category entity) {
        return null;
    }

    private Category getBuild(ResultSet resultSet) throws SQLException {
        return Category.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }

    public static CategoryDao getInstance() {
        return INSTANCE;
    }
}
