package com.demo.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/30.
 */
@Component
public class UserUtil {
    //生成唯一id
    public String makeUserId(){
        Long l = new Date().getTime();
        return  l+makeNickName();
    }
    //生成随机用户名
    public String makeNickName(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String str = "qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < 8; i++) {
            int r = random.nextInt(9);
            String str2 = str.substring(r,r+1);
            stringBuilder.append(str2).append(r);
        }
        return stringBuilder.toString();
    }
    //生成32位md5码
    public String string2MD5(String inStr){
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

//    public static void main(String[] args) {
//        String s = "admin";
//        UserUtil userUtil = new UserUtil();
//        String smd5 = userUtil.string2MD5(s);
//        System.out.println("md5--------"+smd5);
//        String s1 = userUtil.convertMD5(smd5);
//        System.out.println("加密"+s1);
//        String s2 = userUtil.convertMD5(s1);
//        System.out.println("解密"+s2);
//
//    }


}
