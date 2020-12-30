package com.socian_network.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.socian_network.main.codebase.database;

@Controller
public class Registration {
    @RequestMapping(value = "/registration")
    @ResponseBody
    public String Perform(HttpServletRequest request) throws IOException {
        try {
            String user_name = request.getParameter("user_name");
            String user_password = request.getParameter("user_password");

            if (user_name.isEmpty() && user_password.isEmpty()) {
                throw new IOException("user_name or user_password is null");
            }

            return String.format("Everything is okay. You are %s and your password is %s", user_name, user_password);
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
