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

@WebServlet(value = "/view")
public class ViewController extends HttpServlet {

    private final PaintService paintService = PaintService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        String currentUser = (String) session.getAttribute("user");

        if (currentUser == null) {
            resp.sendRedirect("/login");
            return;
        }

        String name = req.getParameter("name");
        String owner = req.getParameter("owner");

        if (name == null || name.isEmpty()) {
            resp.sendRedirect("/private");
            return;
        }

        Paint paint = null;

        if (owner != null && !owner.isEmpty()) {
            paint = paintService.getAllPaints().stream()
                    .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                    .findFirst()
                    .orElse(null);
        } else {
            paint = paintService.getPaintsByOwner(currentUser).stream()
                    .filter(p -> p.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }

        if (paint == null) {
            resp.sendRedirect("/paint");
            return;
        }

        req.setAttribute("paintName", paint.getName());
        req.setAttribute("paintOwner", paint.getOwner());
        req.setAttribute("drawingData", paint.getData());
        req.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(req, resp);
    }
}

