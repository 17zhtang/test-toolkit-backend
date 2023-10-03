package com.hltn.test.controller;

import com.hltn.test.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("devices")
public class DevicesController {
    @PostMapping("getDevices")
    public Result getDevices(){
        return Result.ok(null);
    }
}
