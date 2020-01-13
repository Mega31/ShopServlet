package com.shop.in.model;

import javax.enterprise.context.ApplicationScoped;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Scanner;

@ApplicationScoped
public class DBbean {
    public Connection driverInitilization() throws ClassNotFoundException,  SQLException {

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://127.0.1.1:5432/shopdatabase";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","Postgres");
        props.setProperty("ssl","flase");
        Connection conn = DriverManager.getConnection(url, props);
        return conn;
    }

}
