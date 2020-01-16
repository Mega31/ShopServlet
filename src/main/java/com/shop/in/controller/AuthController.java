package com.shop.in.controller;

import com.shop.in.model.AuthenticationBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class AuthController extends HttpServlet {

     @Inject  private AuthenticationBean auth;
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("test","t1");
        String Usrname = req.getParameter("Username");
        String Pasword = req.getParameter("Password");
         try {
             if (auth.auth2(Usrname,Pasword)){
                 resp.sendRedirect("panel");
             }
             else {
                 PrintWriter writer = resp.getWriter();

                 // build HTML code
                 String htmlResp = "<html>";
                 htmlResp += "<h2>incorrect pass <br/>";

                 htmlResp += "</html>";

                 // return response
                 writer.println(htmlResp);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

     }
}
