package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionSingleton {
    private static MySqlConnectionSingleton instance = null;

    private MySqlConnectionSingleton(){
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    public static MySqlConnectionSingleton getInstance(){
        if (instance == null) {
            instance = new MySqlConnectionSingleton();
        }
        return instance;
    }
}
