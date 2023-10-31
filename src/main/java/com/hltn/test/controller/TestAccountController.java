package com.hltn.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hltn.test.dto.req.AddTestAccountReqDto;
import com.hltn.test.dto.req.GetTestAccountsReqDto;
import com.hltn.test.dto.resp.GetTestAccountsRespDto;
import com.hltn.test.entity.TestAccount;
import com.hltn.test.service.TestAccountService;
import com.hltn.test.utils.JwtHelper;
import com.hltn.test.utils.Result;
import com.hltn.test.utils.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("testAccount")
public class TestAccountController {
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    TestAccountService testAccountService;
    @PostMapping("getTestAccounts")
    public Result getTestAccounts(@RequestBody GetTestAccountsReqDto dto){
        log.info("getTestAccounts,dto:{}", dto);
        IPage<GetTestAccountsRespDto> page =testAccountService.getTestAccounts(dto);
        return  Result.ok(page);
    }

    @GetMapping("getTestAccountById")
    public Result getTestAccountById(@RequestParam long id){
        TestAccount testAccount = testAccountService.getById(id);
        return Result.ok(testAccount);
    }

    @PostMapping("saveTestAccount")
    public Result saveTestAccount(@RequestBody TestAccount testAccount){
        testAccountService.updateById(testAccount);
        return Result.ok(null);
    }

    @PostMapping("addTestAccount")
    public Result addTestAccount(@RequestBody TestAccount testAccount, @RequestHeader String token){
        boolean expiration = jwtHelper.isExpiration(token);
        if(expiration){
            return Result.build(null, ResultCodeEnum.NOT_LOGIN);
        }
        int userId = jwtHelper.getUserId(token).intValue();
        testAccount.setCreatorId((long) userId);
        Boolean flag = testAccountService.save(testAccount);
        if(flag){
            return Result.ok(null);
        }else {
            return Result.error(null);
        }

    }


}
