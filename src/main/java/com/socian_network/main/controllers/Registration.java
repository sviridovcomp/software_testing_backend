package com.socian_network.main.controllers;

import com.google.gson.Gson;
import com.socian_network.main.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class Registration {
    @RequestMapping(value = "/api/registration")
    @ResponseBody
    public void Perform(HttpServletResponse response, HttpServletRequest request) throws IOException, SQLException {
        if (request.getMethod().equals("POST")) {
            try {
                System.out.println(request.getReader());
                Gson json = new Gson();
                User user = json.fromJson(request.getReader(), User.class);

                if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
                    throw new IOException("user_name or user_password is null");
                }

                String user_id = new User(user.getName(), user.getPassword()).create();

                response.addCookie(new Cookie("user_id", user_id));

            } catch (IOException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
