package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserList extends User {
    public UserList(String name, String password) {
        super(name, password);
    }

    public static List<User> Get() throws SQLException {
        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
                "SELECT id, name FROM user ORDER BY name LIMIT 50"
        );

        ResultSet rows = p.executeQuery();

        List<User> UserList = new ArrayList<User>();
        while (rows.next()) {
            User u = new User(rows.getString("name"), "");
            u.id = rows.getInt("id");

            UserList.add(u);
        }

        return UserList;
    }
}
