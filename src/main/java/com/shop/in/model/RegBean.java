package com.shop.in.model;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;

@ApplicationScoped
public class RegBean {

    @Resource(name = "jdbc/db")
    private DataSource dataSource;
    private HashMap<String,String> hashMap = new HashMap<>();
    public boolean userNameCheck(String userName) throws SQLException, ClassNotFoundException {
        Connection connection = dataSource.getConnection() ;
        Statement createSmt= connection.createStatement();
        ResultSet query = createSmt.executeQuery("SELECT * FROM customerdata.customer_data ");
        System.out.println("hhhhh");
        while (query.next()){
            String uName = query.getString("username");
            if (userName.equals(uName)){
                return false;
            }
        }
        return true;
    }
    public void userCreation(String userName,String confirmPass) throws SQLException, ClassNotFoundException {
        Connection connection = dataSource.getConnection();
        String query = "INSERT INTO customerdata.customer_data(username, password) "+"VALUES (?,?)";
        PreparedStatement createSmt= connection.prepareStatement(query);
        createSmt.setString(1,userName);
        createSmt.setString(2,confirmPass);
        System.out.println(query);
        int creatingUserAC=0;
        creatingUserAC = createSmt.executeUpdate();

    }
}
