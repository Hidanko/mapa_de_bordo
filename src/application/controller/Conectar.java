package application.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    public static Connection con = null;

    public static Connection Conectar() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/piratesofsea", "postgres", "123456");
            return con;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}