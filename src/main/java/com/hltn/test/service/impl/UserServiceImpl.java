package com.hltn.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hltn.test.entity.User;
import com.hltn.test.service.UserService;
import com.hltn.test.mapper.UserMapper;
import com.hltn.test.utils.JwtHelper;
import com.hltn.test.utils.MD5Util;
import com.hltn.test.utils.Result;
import com.hltn.test.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 18749
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-10-03 19:19:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount,user.getAccount());
        User loginUser = userMapper.selectOne(queryWrapper);
        //未知账号
        if(loginUser == null){
            return Result.build(null, ResultCodeEnum.ACCOUNT_ERROR);
        }
        //密码错误
        if(!MD5Util.encrypt(user.getPassword()).equals(loginUser.getPassword())){
            return Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
        }

        String token = jwtHelper.createToken(loginUser.getId());

        return Result.ok(token);
    }

    @Override
    public Result register(User user) {
        //检查账号是否已存在
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getAccount,user.getAccount());
        User existingUser = userMapper.selectOne(queryWrapper);
        if(!(existingUser == null)){
            return Result.build(null,ResultCodeEnum.ACCOUNT_EXIST);
        }
        //加密
        user.setPassword(MD5Util.encrypt(user.getPassword()));

        userMapper.insert(user);

        return Result.ok("null");
    }

    @Override
    public Result getUserInfo(String token) {
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            return Result.build(null,ResultCodeEnum.NOT_LOGIN);
        }
        int userId = jwtHelper.getUserId(token).intValue();
        User user = userMapper.selectById(userId);
        user.setPassword("");
        return Result.ok(user);
    }


}




