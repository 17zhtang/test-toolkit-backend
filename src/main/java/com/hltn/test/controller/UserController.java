package com.hltn.test.controller;

import com.hltn.test.entity.User;
import com.hltn.test.service.UserService;
import com.hltn.test.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    public Result login(@RequestBody User user){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("日志测试");
        Result result = userService.login(user);
        return result;
    }

    @PostMapping("register")
    public Result register(@RequestBody User user){
        Result result = userService.register(user);
        return result;
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);
        return result;
    }
}
