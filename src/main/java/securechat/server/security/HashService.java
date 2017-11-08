package securechat.server.security;

import org.apache.commons.lang.ArrayUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

/**
 * Created by sasch on 01/11/2017.
 */
public class HashService {

    public static byte[] hash(byte[] input, byte[] salt) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        ArrayUtils.addAll(input,salt);
        md.update(salt.toString().getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();
        return digest;
    }

}