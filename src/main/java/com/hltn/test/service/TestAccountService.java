package com.hltn.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hltn.test.dto.req.GetTestAccountsReqDto;
import com.hltn.test.dto.resp.GetTestAccountsRespDto;
import com.hltn.test.entity.TestAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 18749
* @description 针对表【test_account(测试账号表)】的数据库操作Service
* @createDate 2023-10-15 23:25:59
*/
public interface TestAccountService extends IService<TestAccount> {

    IPage<GetTestAccountsRespDto> getTestAccounts(GetTestAccountsReqDto dto);
}
