package com.example.servlet.project.dao;

import com.example.servlet.project.entity.User;
import com.example.servlet.project.util.ConnectionManager;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserDao implements Dao<Long, User> {
    private static final UserDao INSTANCE = new UserDao();
    private static final String SAVE_SQL = "INSERT INTO users(name, surname, phone, email, birthday, password, gender)" +
            "VALUES (?,?,?,?,?,?,?)";


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getSurname());
            preparedStatement.setObject(3, entity.getPhone());
            preparedStatement.setObject(4, entity.getEmail());
            preparedStatement.setDate(5, Date.valueOf(entity.getBirthday()));
            preparedStatement.setObject(6, entity.getPassword());
            preparedStatement.setObject(7, entity.getGender().name());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getLong("id"));
            return entity;
        }
    }


    public static UserDao getInstance() {
        return INSTANCE;
    }
}
