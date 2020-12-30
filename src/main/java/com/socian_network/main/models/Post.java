package com.socian_network.main.models;

import com.socian_network.main.codebase.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Post {
    public void create(String owner_name,
                       String author_name,
                       String message) {
        this.owner_name = owner_name;
        this.author_name = author_name;
        this.message = message;
    }

    public static List<Post> Get(int owner_id) throws SQLException {
        Connection handler = database.connect();

        PreparedStatement p = handler.prepareStatement(
                "SELECT (SELECT name FROM user WHERE id = p.owner_id) as owner_name," +
                        "(SELECT name FROM user WHERE id = p.author_id) as author_name," +
                        "p.message FROM post p WHERE owner_id = ?;"
                );

        p.setInt(1, owner_id);
        ResultSet rows = p.executeQuery();

        List<Post> PostList = new ArrayList<Post>();
        while (rows.next()) {
            var temp = new Post();
            temp.create(rows.getString("owner_name"),
                    rows.getString("author_name"),
                    rows.getString("message"));
            PostList.add(temp);
        }

        return PostList;
    }

    private int id;
    private int owner_id;
    private int author_id;
    private String author_name;
    private String owner_name;
    private String message;
}
