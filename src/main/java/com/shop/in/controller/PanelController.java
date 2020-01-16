package com.shop.in.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/panel")
public class PanelController extends HttpServlet {
    String fruits = "banana";
    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Fruits",fruits);
       // req.setAttribute("vegetables",readingBean.vegReader());
        req.getRequestDispatcher("panel.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }
}
