package com.esliceu.servlets.controllers;


import com.esliceu.servlets.models.Paint;
import com.esliceu.servlets.services.PaintService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/private")
public class PrivateController extends HttpServlet {

    private PaintService paintService = PaintService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if ( user== null){
            resp.sendRedirect("/login");
            return;
        }

        List<Paint> userPaints = paintService.getPaintsByOwner(user);
        req.setAttribute("paintList", userPaints);

        req.getRequestDispatcher("/WEB-INF/jsp/privateGal.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String user = (String) session.getAttribute("user");

        if (user == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("{\"success\": false, \"message\": \"User not logged in.\"}");
            return;
        }

        String action = req.getParameter("action");
        String name = req.getParameter("name");

        if ("delete".equals(action)) {
            boolean deleted = paintService.deletePaintByNameAndOwner(name, user);
            resp.setContentType("application/json");
            resp.getWriter().write("{\"success\": " + deleted + "}");
        } else  {
            resp.getWriter().write("{\"success\": false, \"message\": \"Something was happen.\"}");
        }

    }

}
