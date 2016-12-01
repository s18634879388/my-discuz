package com.demo.service;

import com.demo.domain.LoginInfo;
import com.demo.domain.UserInfo;
import com.demo.mapper.UserWrapperMapper;
import com.demo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/11/30.
 */
@Service
@Transactional
public class UserInfoService {

    @Autowired
    UserWrapperMapper userWrapperMapper;
    @Autowired
    UserUtil userUtil;
    public void regist(LoginInfo loginInfo) {
        //添加新注册的用户名密码
        userWrapperMapper.addLoginInfo(loginInfo);
        //添加新注册的用户基本信息，userinfo
        String nickname = userUtil.makeNickName();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(loginInfo.getId());
        userInfo.setNickName(nickname);
        userWrapperMapper.addUserInfo(userInfo);

    }
}
