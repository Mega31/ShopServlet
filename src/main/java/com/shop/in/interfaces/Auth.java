package com.shop.in.interfaces;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface Auth {
    boolean authentication(String userId, String pass) throws IOException, NoSuchAlgorithmException;
}
