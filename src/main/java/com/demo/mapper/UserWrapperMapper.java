package com.demo.mapper;

import com.demo.domain.LoginInfo;
import com.demo.domain.UserInfo;

/**
 * Created by Administrator on 2016/11/30.
 */
public interface UserWrapperMapper {
    void addLoginInfo(LoginInfo loginInfo);

    void addUserInfo(UserInfo userInfo);
}
