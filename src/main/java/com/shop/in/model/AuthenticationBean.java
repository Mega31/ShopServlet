package com.shop.in.model;

import com.shop.in.interfaces.Auth;

import javax.enterprise.context.*;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.sql.*;

@RequestScoped
public class AuthenticationBean  {
    @Inject private DBbean dBbean;
   @Inject private HashBean hashing;
    private BufferedReader userReader,passReader;
   // private  static final String PASSWD_PATH = "/passwd.txt";
    //private  static final String USER_NAME_PATH = "/userName.txt";
    //private  String user,passwd;
    //private List<String> userList ,passList,gUser,gPass ;
    private Map<String,String> hashMap = new HashMap<String,String>();
   // @Override
   /* public boolean authentication (String userId,String pass ) throws IOException, NoSuchAlgorithmException {
        InputStream userStream = AuthenticationBean.class.getResourceAsStream(USER_NAME_PATH);
        InputStream passStream = AuthenticationBean.class.getResourceAsStream(PASSWD_PATH);
        InputStreamReader userStreamReader = new InputStreamReader(userStream);
        InputStreamReader passStreamReader = new InputStreamReader(passStream);
        userReader = new BufferedReader(userStreamReader);
        passReader = new BufferedReader(passStreamReader);

        while ((user = userReader.readLine()) != null && (passwd = passReader.readLine()) != null) {
            String usrID = Arrays.toString(user.split(","));
            String passID = Arrays.toString(passwd.split(","));
            hashMap.put( usrID,passID);
            System.out.println(usrID +" n "+ passID);
        }
        System.out.println(hashMap);
        String hashPass = hashing.returnHash(pass);
        System.out.println(hashMap.values() +" value and key "+hashMap.keySet());

        boolean checkPass= hashMap.containsValue('['+hashPass+']');
        boolean checkUser = hashMap.containsKey('['+userId+']');
        System.out.println(checkUser +" and "+ checkPass);
        if (checkUser && checkPass) {
            System.out.println("log");
            return true;

        }
        System.out.println("not log");
        userReader.close();
        passReader.close();
        return false;

    }
    */
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
