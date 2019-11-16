package com.shop.in.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    private String md5Hash(String input){
        try {
            MessageDigest hashType = MessageDigest.getInstance("MD5");
            byte[] messageDigest = hashType.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public  String returnHash(String input) throws NoSuchAlgorithmException {
        return md5Hash(input);
    }
}
