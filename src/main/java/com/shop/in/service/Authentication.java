package com.shop.in.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Authentication {
    private Hashing hashing;
    private BufferedReader userReader,passReader;
    private  static final String PASSWD_PATH = "/passwd.txt";
    private  static final String USER_NAME_PATH = "/userName.txt";
    private  String user,passwd;
    private List<String> userList ,passList ;
    private Map<List<String>,List<String>> hashMap = new HashMap<List<String>,List<String>>();



    public Authentication(Hashing hashing){
        this.hashing = hashing;
    }


    public boolean authentication (String userId,String pass ) throws IOException, NoSuchAlgorithmException {

        userReader = new BufferedReader(new FileReader(USER_NAME_PATH));
        passReader = new BufferedReader(new FileReader(PASSWD_PATH));
        userList = new ArrayList<String>();
        passList = new ArrayList<String>();
        while ((user = userReader.readLine()) != null && (passwd = passReader.readLine()) != null) {
            userList.addAll(Arrays.asList(user.split(",")));
            passList.addAll(Arrays.asList(passwd.split(",")));
        }
        String hashPass = hashing.returnHash(pass);
        hashMap.put(userList, passList);
        boolean checkUser = hashMap.containsKey(userId);
        boolean checkPass = hashMap.containsValue(hashPass);
        if (checkUser && checkPass) {
            return true;
        }
        userReader.close();
        passReader.close();
        return false;
    }
}
