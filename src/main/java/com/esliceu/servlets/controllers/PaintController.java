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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.time.LocalDate;

@WebServlet(value = "/paint")
public class PaintController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if ( user== null){
            resp.sendRedirect("/login");
            return;
        }

        req.getRequestDispatcher("/WEB-INF/jsp/paint.jsp")
                .forward(req, resp);
    }

    private PaintService paintService = PaintService.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String drawingDataJson = request.getParameter("drawingData");
        LocalDate myObj = LocalDate.now();

        HttpSession session = request.getSession();
        String owner = (String) session.getAttribute("user");

        if (name == null || drawingDataJson == null) {
            response.getWriter().write("{\"success\": false, \"message\": \"missing parameters\"}");
            return;
        }

        if (paintService.selectPaintByNameAndOwner(name, owner)) {
            response.getWriter().write("{\"success\": false, \"message\": \"You have a paint with that name.\"}");
            return;
        }

        Paint paint = new Paint(name, drawingDataJson, owner, myObj);
        boolean saved = paintService.savePaint(paint);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        if (saved) {
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false, \"message\": \"Failed to save paint.\"}");
        }
    }

}
