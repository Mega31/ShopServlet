package com.shop.in.controller;

import com.shop.in.interfaces.Auth;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;


@WebServlet("/panel")
public class AuthController extends HttpServlet {
    @Inject private Auth auth;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String Usrname = req.getParameter("Username");
        String Pasword = req.getParameter("Password");

        try {
            if (auth.authentication(Usrname,Pasword)){
               resp.sendRedirect("panel.jsp");

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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
