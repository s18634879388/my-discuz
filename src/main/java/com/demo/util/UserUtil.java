package com.demo.util;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/30.
 */
@Component
public class UserUtil {
    //
    public String makeUserId(){
        Long l = new Date().getTime();
        return  l+makeNickName();
    }
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


}
