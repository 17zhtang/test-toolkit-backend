package com.hltn.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hltn.test.dto.req.GetTestAccountsReqDto;
import com.hltn.test.dto.resp.GetTestAccountsRespDto;
import com.hltn.test.service.TestAccountService;
import com.hltn.test.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testAccount")
public class TestAccountController {
    @Autowired
    TestAccountService testAccountService;
    @PostMapping("getTestAccounts")
    public Result getTestAccounts(@RequestBody GetTestAccountsReqDto dto){
        IPage<GetTestAccountsRespDto> page =testAccountService.getTestAccounts(dto);
        return  Result.ok(page);
    }
}
