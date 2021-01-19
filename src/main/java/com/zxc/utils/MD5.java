package com.zxc.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static StringBuffer getMD5(String source) throws NoSuchAlgorithmException{
        //将明文转换成byte[]
        byte [] bytes = source.getBytes();
        //将byte字节数组通过MessageDigest进行MD5运算，得到一个新的字节数组。
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte [] newBytes = md.digest(bytes);
        //将新的字节数组转换成密文
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < newBytes.length; i++) {
            sb.append(String.format("%02X", newBytes[i]));
        }
        return sb;
    }
}
