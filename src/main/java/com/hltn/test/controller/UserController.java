package com.hltn.test.controller;

import com.hltn.test.entity.User;
import com.hltn.test.service.UserService;
import com.hltn.test.utils.Result;
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
        Result result = userService.login(user);
        return result;
    }

    @PostMapping("register")
    public Result register(@RequestBody User user){
        Result result = userService.register(user);
        return result;
    }

    @PostMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        Result result = userService.getUserInfo(token);
        return result;
    }
}
