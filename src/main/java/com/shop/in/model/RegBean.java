package com.shop.in.model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

@ApplicationScoped
public class RegBean {
    @Inject private DBbean dBbean;
    private HashMap<String,String> hashMap = new HashMap<>();
    public boolean userNameCheck(String userName) throws SQLException, ClassNotFoundException {
        Connection DBconnection = dBbean.driverInitilization();
        Statement createSmt= DBconnection.createStatement();
        ResultSet query = createSmt.executeQuery("SELECT * FROM customerdata.customer_data ");
        while (query.next()){
            String uName = query.getString("username");
            if (userName.equals(uName)){
                return false;
            }
        }
        query.close();
        createSmt.close();
        DBconnection.close();
        return true;
    }
    public void userCreation(String userName,String confirmPass) throws SQLException, ClassNotFoundException {
        Connection DBconnection = dBbean.driverInitilization();
        Statement createSmt= DBconnection.createStatement();
        ResultSet creatingUserAC = createSmt.executeQuery("INSERT INTO customerdata.customer_data(userName,password)"+"VALUES  ("+userName+","+confirmPass+")");
        createSmt.close();
        creatingUserAC.close();
        DBconnection.close();
    }
}
