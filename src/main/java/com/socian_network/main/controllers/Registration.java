package com.socian_network.main.controllers;

import com.google.gson.Gson;
import com.socian_network.main.codebase.cookie;
import com.socian_network.main.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class Registration {
    @CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
    @RequestMapping(value = "/api/registration")
    public @ResponseBody void Perform(HttpServletResponse response, HttpServletRequest request) throws IOException, SQLException {
        if (request.getMethod().equals("POST")) {

            if (cookie.Get(request, "user_id").isEmpty()) {
                try {
                    Gson json = new Gson();
                    User user = json.fromJson(request.getReader(), User.class);

                    if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
                        throw new IOException("user_name or user_password is null");
                    }

                    String user_id = user.create();

                    response.addCookie(new Cookie("user_id", user_id));

                } catch (IOException | SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                // TODO: Redirect to user panel
            }
        }
    }
}
