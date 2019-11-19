package com.shop.in.service;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Authentication {
    private Hashing hashing;
    private BufferedReader userReader,passReader;
    private  static final String PASSWD_PATH = "/passwd.txt";
    private  static final String USER_NAME_PATH = "/userName.txt";
    private  String user,passwd;
    private List<String> userList ,passList,gUser,gPass ;
    private Map<String,String> hashMap = new HashMap<String,String>();



    public Authentication(Hashing hashing){
        this.hashing = hashing;
    }


    public boolean authentication (String userId,String pass ) throws IOException, NoSuchAlgorithmException {
        InputStream userStream = Authentication.class.getResourceAsStream(USER_NAME_PATH);
        InputStream passStream = Authentication.class.getResourceAsStream(PASSWD_PATH);
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

}
