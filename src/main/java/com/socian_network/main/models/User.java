package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String create() throws SQLException {
        // TODO: Check existing of account

        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
            "INSERT INTO user (name, password) VALUES (?, ?)"
        );

        p.setString(1, this.name);
        p.setString(2, this.password);
        p.executeUpdate();
        return p.getGeneratedKeys().getString(1);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    private int id;
    private final String name;
    private final String password;
}

