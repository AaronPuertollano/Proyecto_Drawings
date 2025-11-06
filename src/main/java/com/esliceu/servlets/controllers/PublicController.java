package com.esliceu.servlets.controllers;


import com.esliceu.servlets.models.Paint;
import com.esliceu.servlets.services.PaintService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (value = "/public")
public class PublicController extends HttpServlet {

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

        List<Paint> publicPaints = paintService.getAllPaints();
        req.setAttribute("paintList", publicPaints);

        req.getRequestDispatcher("/WEB-INF/jsp/publicGal.jsp").forward(req, resp);
    }

}
