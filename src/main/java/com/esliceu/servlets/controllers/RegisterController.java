package com.esliceu.servlets.controllers;


import com.esliceu.servlets.dao.UserDAOInMemory;
import com.esliceu.servlets.models.User;
import com.esliceu.servlets.services.PaintService;
import com.esliceu.servlets.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
                .forward(req, resp);
    }

    private UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (name == null || username == null || password == null ||
                name.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()) {
            req.setAttribute("message", "Please fill all fields");
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
            return;
        }

        User newUser = new User(name, username, password);

        boolean success = userService.addUser(newUser);
        /*
        boolean success = UserDAOInMemory.addUser(newUser);*/

        if (success) {
            resp.sendRedirect("/login");
        } else {
            // Usuario ya existe
            req.setAttribute("message", "Error, change the username");
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
                    .forward(req, resp);
        }
    }
}
