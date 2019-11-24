package com.shop.in.controller;

import com.shop.in.model.ReadingBean;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PanelController extends HttpServlet {
    @Inject private ReadingBean readingBean;


    protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Fruits",readingBean.fruitReader());
        req.setAttribute("vegetables",readingBean.vegReader());
        RequestDispatcher dispatcher = req.getRequestDispatcher("panel.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req,resp);
    }
}
