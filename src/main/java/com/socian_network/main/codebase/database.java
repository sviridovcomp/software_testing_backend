package com.socian_network.main.codebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connect() throws SQLException {
        Connection dbHandler = null;

        try {
            dbHandler = DriverManager.getConnection(
                    "jdbc:sqlite:db.sqlite");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return dbHandler;
    }
}