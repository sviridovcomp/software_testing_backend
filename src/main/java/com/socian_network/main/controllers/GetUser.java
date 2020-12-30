package com.socian_network.main.controllers;

import com.google.gson.Gson;
import com.socian_network.main.models.UserList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class GetUser {
    @RequestMapping(value = "/api/getListOfUsers")
    public @ResponseBody void UserList(HttpServletResponse response, HttpServletRequest request) throws SQLException, IOException {
        if (request.getMethod().equals("GET")) {
            Gson json = new Gson();

            String serialized = json.toJson(UserList.Get());
            System.out.println(serialized);

            PrintWriter out = response.getWriter();
            out.println(serialized);
        }
    }
}
