package org.wuxinshui.boosters.md5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    public static Long generateUid(String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            md5.update(msg.getBytes("UTF-8"));

            BigInteger bigInteger = new BigInteger(1, md5.digest(), 2, 4);

            return bigInteger.abs().longValue();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return new BigInteger(msg.getBytes(),2,4).abs().longValue();
    }

}
