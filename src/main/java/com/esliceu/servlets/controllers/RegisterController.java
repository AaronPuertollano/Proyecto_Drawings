package com.esliceu.servlets.controllers;


import com.esliceu.servlets.dao.UserDAO;
import com.esliceu.servlets.models.User;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Recoger parámetros del formulario
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Validación simple (campos vacíos)
        if (name == null || username == null || password == null ||
                name.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty()) {
            req.setAttribute("message", "Please fill all fields");
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
            return;
        }

        // Intentar registrar el usuario
        User newUser = new User(name, username, password);
        boolean success = UserDAO.addUser(newUser);

        if (success) {
            // Registro exitoso → redirigir a login con mensaje
            req.setAttribute("message", "User registered successfully! You can now log in.");
            resp.sendRedirect("/login");
        } else {
            // Usuario ya existe → volver al registro
            req.getRequestDispatcher("/WEB-INF/jsp/register.jsp")
                    .forward(req, resp);
        }
    }
}
