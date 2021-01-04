package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String user_id) {
        this.id = Integer.parseInt(user_id);
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

    public String authentication() throws SQLException {
        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
            "SELECT id, password FROM user WHERE name = ? LIMIT 1"
        );

        p.setString(1, this.name);
        ResultSet rows = p.executeQuery();

        int user_id = rows.getInt("id");
        String password_form_db = rows.getString("password");

        if (this.password.equals(password_form_db)) {
            return Integer.toString(user_id);
        } else {
            return null;
        }
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    protected int id;
    protected String name;
    protected String password;
}

