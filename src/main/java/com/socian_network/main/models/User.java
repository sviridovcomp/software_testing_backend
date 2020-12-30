package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
    public User(String name, String password) {
        this.name_ = name;
        this.password_ = password;
    }

    public String create() throws SQLException {
        // TODO: Check existing of account

        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
            "INSERT INTO user (name, password) VALUES (?, ?)"
        );

        p.setString(1, this.name_);
        p.setString(2, this.password_);
        p.executeUpdate();
        return p.getGeneratedKeys().getString(1);
    }

    private final String name_;
    private final String password_;
}
