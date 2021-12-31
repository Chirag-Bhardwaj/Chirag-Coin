////////////////////////////// FILE HEADER /////////////////////////////////////
//
// Title:    Blockchain – GenerateHash.java
//
// Author:   Chirag Bhardwaj
// Email:    chiragbhardwaj2002@gmail.com
//
////////////////////////////// Description /////////////////////////////////////
//
// A simple and secure Blockchain software made using the SHA256 algorithm.
// Changing any data will result in breaking of the entire chain, thus
// making this Blockchain robust.
//
////////////////////////////////////////////////////////////////////////////////

import java.security.MessageDigest;

public class GenerateHash {

    public static String sha256(String input) {

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
