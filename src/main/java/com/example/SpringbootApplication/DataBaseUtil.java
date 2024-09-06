package com.example.SpringbootApplication;

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:sqlite:test.db";

    public static Connection connect() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}