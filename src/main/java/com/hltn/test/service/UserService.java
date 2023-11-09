package com.hltn.test.service;

import com.hltn.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hltn.test.utils.Result;

/**
* @author 18749
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-10-03 19:19:01
*/
public interface UserService extends IService<User> {

    Result login(User user);

    Result register(User user);

    Result getUserInfo(String token);

    String getToken(Long uid);

    Result logout(String token);
}
