package com.example.servlet.project.util;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectionManager {
    private static final String URL = "url";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    static {
        loadDriver();
    }


    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection open() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(LOGIN),
                    PropertiesUtil.get(PASSWORD)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
