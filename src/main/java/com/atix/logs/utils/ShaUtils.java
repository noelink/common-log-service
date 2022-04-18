package com.atix.logs.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public final class ShaUtils {

    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String SHA_ALGORITHM = "SHA-256";

    private ShaUtils() {
        super();
    }

    public static byte[] digest(byte[] input, String algorithm) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
            return md.digest(input);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static String getSHAKey(StringBuilder stringBuilder) {
        String kText = stringBuilder.toString();
        byte[] shaInBytes = ShaUtils.digest(kText.getBytes(UTF_8), SHA_ALGORITHM);
        return bytesToHex(shaInBytes);
    }
    
    public static String generateRandomLineHash() {
    	int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
              (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return getSHAKey(buffer);
    }
   
}
