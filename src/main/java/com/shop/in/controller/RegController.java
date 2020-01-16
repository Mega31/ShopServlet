package com.shop.in.controller;

import com.shop.in.model.RegBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Reg")
public class RegController extends HttpServlet {

    @Inject private  RegBean regBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req,resp);
        System.out.println("test");
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Usrname = req.getParameter("Username");
        String Pasword = req.getParameter("newPassword");
        String newPasswd = req.getParameter("confirmPassword");
        System.out.println("test2");
        try {
            if (!Pasword.equals(newPasswd)) {
                PrintWriter writer = resp.getWriter();

                // build HTML code
                String htmlResp = "<html>";
                htmlResp += "<h2>password didnt matched <br/>";

                htmlResp += "</html>";

                // return response
                writer.println(htmlResp);

            }else {

             if (regBean.userNameCheck(Usrname)){
                regBean.userCreation(Usrname,newPasswd);
                resp.sendRedirect("/ShopServlet_war_exploded");
                System.out.println("inserted");
            }
            else {
                PrintWriter writer = resp.getWriter();

                // build HTML code
                String htmlResp = "<html>";
                htmlResp += "<h2>used username <br/>";

                htmlResp += "</html>";

                // return response
                writer.println(htmlResp);
            }
        }
    } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
