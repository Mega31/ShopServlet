package com.shop.in.controller;

import com.shop.in.model.ReadingBean;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class PanelController extends HttpServlet {
    //@Inject private ReadingBean readingBean;
    public PanelController() throws IOException {
    }
    //private ArrayList<String> fruits = (ArrayList<String>) readingBean.fruitReader();
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
