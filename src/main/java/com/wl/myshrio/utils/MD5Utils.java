package com.wl.myshrio.utils;

import org.jooq.util.derby.sys.Sys;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/**
 * MD5辅助类
 */
public class MD5Utils {
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final String MD5Encrpytion(String source) {
        try {
            byte[] strTemp = source.getBytes(Charset.forName("UTF-8"));
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
                str[(k++)] = hexDigits[(byte0 & 0xF)];
            }
            for (int m = 0; m < str.length; ++m) {
                if ((str[m] >= 'a') && (str[m] <= 'z')) {
                    str[m] = (char) (str[m] - ' ');
                }
            }
            return new String(str);
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        String a = MD5Encrpytion("a123456");
        System.out.println("a == "+a);
        String b = MD5Encrpytion(a);
        System.out.println("b == "+b);
    }
}