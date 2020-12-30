package com.socian_network.main.codebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    private static void connect_() throws SQLException {
        try {
            String path_to_database = "jdbc:sqlite:~/code/software-testing/main/database.sqlite";
            Connection dbHandler = DriverManager.getConnection(path_to_database);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main() throws SQLException {
        connect_();
    }
}
