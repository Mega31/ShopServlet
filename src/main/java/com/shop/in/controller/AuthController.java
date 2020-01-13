package com.shop.in.controller;

import com.shop.in.interfaces.Auth;
import com.shop.in.model.AuthenticationBean;
import com.shop.in.model.DBbean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;



public class AuthController extends HttpServlet {
private  DBbean dBbean = new DBbean();
     @Inject  private AuthenticationBean auth;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("test","t1");
        String Usrname = req.getParameter("Username");
        String Pasword = req.getParameter("Password");
        System.out.println("dcsdvdfvdvdv");

        try {
            if (auth.auth2(Usrname,Pasword)){
                System.out.println("sfsdfdsfsdx1111");
               resp.encodeRedirectURL("/pa");
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
