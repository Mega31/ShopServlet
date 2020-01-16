package com.shop.in.model;

import javax.enterprise.context.RequestScoped;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RequestScoped
public class AuthenticationBean  {

    @Inject private HashBean hashing;
    @Resource(name = "jdbc/db")
    private DataSource dataSource;

    public boolean auth2(String userName,String pass) throws SQLException {
            //Connection connection = null;
               Connection connection = dataSource.getConnection();
                String sql = "SELECT * FROM customerdata.customer_data";
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                String uName = rs.getString("userName");
                String passwd = rs.getString("password");
                    if (uName.equals(userName) && passwd.equals(pass)){
                    System.out.println(uName+" and " +passwd);
                    return true;
                    }
                }
            return false;
    }
}

