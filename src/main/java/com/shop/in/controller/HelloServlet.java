package com.shop.in.controller;

import com.shop.in.service.Authentication;
import com.shop.in.service.Hashing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@WebServlet("/panel")
public class HelloServlet extends HttpServlet {
    private Hashing hashing = new Hashing();
    private Authentication authentication = new Authentication(hashing);

    //constructor



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Usrname = req.getParameter("Username");
        String Pasword = req.getParameter("Password");
        try {
            if (authentication.authentication(Usrname,Pasword)){
                resp.sendRedirect("test.jsp");

            }
            else {
                PrintWriter writer = resp.getWriter();

                // build HTML code
                String htmlResp = "<html>";
                htmlResp += "<h2>Internal error <br/>";

                htmlResp += "</html>";

                // return response
                writer.println(htmlResp);
            }
        } catch (NoSuchAlgorithmException e) {
            PrintWriter writer = resp.getWriter();

            // build HTML code
            String htmlRespone = "<html>";
            htmlRespone += "<h2>Your username or password incorrect <br/>";

            htmlRespone += "</html>";

            // return response
            writer.println(htmlRespone);
        }
    }
}
