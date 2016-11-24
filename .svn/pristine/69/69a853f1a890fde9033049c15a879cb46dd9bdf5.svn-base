package com.shine.core.utils.common;

import com.shine.core.exception.ServiceException;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Sign RSA加密  MD5
 */
public class SignUtils {
    private static final String ALGORITHM = "RSA";

    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static final String DEFAULT_CHARSET = "UTF-8";
    
    private static final char[] HEX_DIGITS = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static String sign(String content, String privateKey) {
        try {
                PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                                Base64.decode(privateKey));
                KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
                PrivateKey priKey = keyf.generatePrivate(priPKCS8);

                java.security.Signature signature = java.security.Signature
                                .getInstance(SIGN_ALGORITHMS);

                signature.initSign(priKey);
                signature.update(content.getBytes(DEFAULT_CHARSET));

                byte[] signed = signature.sign();

                return Base64.encode(signed);
        } catch (Exception e) {
                e.printStackTrace();
        }

        return null;
   }
    
    public static String md5(String srcStr) {
        return hash("MD5", srcStr);
    }

    public static String hash(String algorithm, String srcStr) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = md.digest(srcStr.getBytes("utf-8"));
            return toHex(bytes);
        } catch (Exception e) {
            throw ServiceException.create("PUBLIC.HASH.ERROR");
        }
    }
    
    private static String toHex(byte[] bytes) {
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString().toLowerCase();
    }
    
    public static void main(String[] args){
        String s = "123456";
        System.out.println(SignUtils.md5(s));
    }
}
