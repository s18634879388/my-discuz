package com.demo.controller;

import com.demo.domain.LoginInfo;
import com.demo.service.UserInfoService;
import com.demo.util.UserUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/11/30.
 */
@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserUtil userUtil;

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String regist(@RequestBody LoginInfo loginInfo){
        loginInfo.setId(userUtil.makeUserId());
        System.out.println(loginInfo.getUserName()+"=========="+loginInfo.getUserPassword()+"=========="+loginInfo.getId());
        userInfoService.regist(loginInfo);
        return "yes";
    }
}
