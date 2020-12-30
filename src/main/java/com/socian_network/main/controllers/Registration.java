package com.socian_network.main.controllers;

import com.socian_network.main.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class Registration {
    @RequestMapping(value = "/registration")
    @ResponseBody
    public void Perform(HttpServletRequest request) throws IOException, SQLException {
        try {
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");

            if (user_name.isEmpty() && user_password.isEmpty()) {
                throw new IOException("user_name or user_password is null");
            }

            String user_id = new User(user_name, user_password).create();

            new Cookie("user_id", user_id);
        } catch (IOException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
