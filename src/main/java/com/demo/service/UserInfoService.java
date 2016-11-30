package com.demo.service;

import com.demo.domain.LoginInfo;
import com.demo.mapper.UserWrapperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/30.
 */
@Service
public class UserInfoService {

    @Autowired
    UserWrapperMapper userWrapperMapper;
    public void regist(LoginInfo loginInfo) {
        userWrapperMapper.addLoginInfo(loginInfo);

    }
}
