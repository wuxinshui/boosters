package org.wuxinshui.boosters.md5;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Md5Util {

    public static Long generateUidFromString(String msg) throws NoSuchAlgorithmException, UnsupportedEncodingException {

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


    public static Long getUUIDFromString(String msg) {
        UUID uuid = UUID.nameUUIDFromBytes(msg.getBytes());

        long version = uuid.version();
        System.out.println("0x0f:"+0x0f);
        System.out.println("version:"+version);
        // long node = uuid.node();
        // System.out.println("node:"+node);
        // long timestamp = uuid.timestamp();
        // System.out.println("timestamp:"+timestamp);
        long leastSigBits = uuid.getLeastSignificantBits();
        System.out.println("leastSigBits:"+leastSigBits);
        long mostSigBits = uuid.getMostSignificantBits();
        System.out.println("mostSigBits:"+mostSigBits);
        return leastSigBits;
    }
    public static Long fromString(String msg) {
        UUID uuid = UUID.fromString(msg);

        long version = uuid.version();
        System.out.println("0x0f:"+0x0f);
        System.out.println("version:"+version);
        long node = uuid.node();
        System.out.println("node:"+node);
        long timestamp = uuid.timestamp();
        System.out.println("timestamp:"+timestamp);
        long leastSigBits = uuid.getLeastSignificantBits();
        System.out.println("leastSigBits:"+leastSigBits);
        long mostSigBits = uuid.getMostSignificantBits();
        System.out.println("mostSigBits:"+mostSigBits);
        return leastSigBits;
    }


    public static void main(String[] args) {
        // String text = "中国移动中国你哥哥";
        String text = "28400000-8cf0-11bd-b23e-10b96e4ef00d";
        // System.out.println(getUUIDFromString(text));
        System.out.println(fromString(text));
    }

}
