package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static List<String> Get() throws SQLException {
        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
                "SELECT * FROM user ORDER BY name LIMIT 50"
        );

        ResultSet rows = p.executeQuery();

        List<String> userNameList = new ArrayList<String>(); // Obviously, we should to using list here, but when I'm using list application don't work.
        while (rows.next()) {
            userNameList.add(rows.getString("name"));
        }

        return userNameList;
    }
}
