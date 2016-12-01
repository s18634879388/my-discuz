package com.demo.controller;

import com.demo.domain.LoginInfo;
import com.demo.service.UserInfoService;
import com.demo.util.UserUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2016/11/30.
 */
@Controller
@RequestMapping(value = "/my-discuz")
@Api(value = "用户中心",description = "用户中心",produces = "text/html")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserUtil userUtil;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    @ApiOperation(value = "注册页面",notes = "注册页面")
    public String welcom(){
        return "regist";
    }

    @RequestMapping(value = "/to-register",method = RequestMethod.POST)
    @ApiOperation(value = "注册",notes = "注册")
    public String regist(
            @ApiParam(value = "login对象")
            @ModelAttribute("loginInfo") LoginInfo loginInfo){
        //加密密码
        String password = loginInfo.getUserPassword();
        String md5 = userUtil.string2MD5(password);
        String md5key = userUtil.convertMD5(md5);
        loginInfo.setUserPassword(md5key);
        System.out.println(loginInfo.getUserName()+"=========="+loginInfo.getUserPassword()+"=========="+loginInfo.getId());
        //生成唯一id
        loginInfo.setId(userUtil.makeUserId());
        System.out.println(loginInfo.getUserName()+"=========="+loginInfo.getUserPassword()+"=========="+loginInfo.getId());
        userInfoService.regist(loginInfo);
        return "freemarker_demo";
    }
}
