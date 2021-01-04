package com.socian_network.main.controllers;

import com.google.gson.Gson;
import com.socian_network.main.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class GetPost {
    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @RequestMapping(value = "/api/GetPosts")
    public @ResponseBody
    void List(HttpServletResponse response, HttpServletRequest request) throws SQLException, IOException {
        if (request.getMethod().equals("GET")) {
            Gson json = new Gson();
            int user_id = Integer.parseInt(request.getParameter("user_id"));

            String serialized = json.toJson(Post.Get(user_id));

            PrintWriter out = response.getWriter();
            out.println(serialized);
        }
    }
}
