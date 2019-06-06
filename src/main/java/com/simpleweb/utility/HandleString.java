package com.simpleweb.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;

public class HandleString {

    public static String generateSalt(){
        UUID uuid = UUID.randomUUID();
        String salt = uuid.toString();
        return salt.substring(0,6);
    }

    public static String stringHash(String password) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] hashBytes = md5.digest(password.getBytes(StandardCharsets.UTF_8));

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashBytes) {
            stringBuilder.append(String.format("%x", b));
        }
        return stringBuilder.toString();
    }

}

