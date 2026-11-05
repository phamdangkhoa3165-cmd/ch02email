package org.example.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = System.getenv("DB_URL") != null
                ? System.getenv("DB_URL")
                : "jdbc:postgresql://ep-silent-breeze-aojgv1lv-pooler.c-2.ap-southeast-1.aws.neon.tech/neondb?sslmode=require";
        String user = System.getenv("DB_USER") != null
                ? System.getenv("DB_USER")
                : "neondb_owner";
        String pass = System.getenv("DB_PASS") != null
                ? System.getenv("DB_PASS")
                : "npg_fmcwk1AM6SLx";

        return DriverManager.getConnection(url, user, pass);
    }
}