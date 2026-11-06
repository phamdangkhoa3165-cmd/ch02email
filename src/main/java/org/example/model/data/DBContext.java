package org.example.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = System.getenv("DB_URL") != null
                ? System.getenv("DB_URL")
                : "jdbc:postgresql://localhost:5432/ch02email";
        String user = System.getenv("DB_USER") != null
                ? System.getenv("DB_USER")
                : "postgres";
        String pass = System.getenv("DB_PASS") != null
                ? System.getenv("DB_PASS")
                : "Khoa@1201";

        return DriverManager.getConnection(url, user, pass);
    }
}