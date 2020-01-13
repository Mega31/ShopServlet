package com.shop.in.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class AuthenticationBean  {
    @Inject private DBbean dBbean;
   @Inject private HashBean hashing;
    private Map<String,String> hashMap = new HashMap<String,String>();

    public boolean auth2(String userName,String pass) throws ClassNotFoundException, SQLException {
       Connection DBconnection = dBbean.driverInitilization();
       Statement createSmt= DBconnection.createStatement();
       ResultSet query = createSmt.executeQuery("SELECT * FROM customerdata.customer_data ");
       while (query.next()){
           String uName = query.getString("username");
           String uPass = query.getString("password");
           hashMap.put( uName,uPass);
       }
        boolean checkPass= hashMap.containsValue(pass);
        boolean checkUser = hashMap.containsKey(userName);
        if (checkPass && checkUser ){
            System.out.println("success");
            return true;
        }
        DBconnection.close();
        createSmt.close();
        query.close();

        return false;
    }



}
