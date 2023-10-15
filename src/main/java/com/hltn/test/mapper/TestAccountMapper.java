package com.hltn.test.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hltn.test.dto.req.GetTestAccountsReqDto;
import com.hltn.test.dto.resp.GetTestAccountsRespDto;
import com.hltn.test.entity.TestAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 18749
* @description 针对表【test_account(测试账号表)】的数据库操作Mapper
* @createDate 2023-10-15 23:25:59
* @Entity com.hltn.test.entity.TestAccount
*/
public interface TestAccountMapper extends BaseMapper<TestAccount> {

    Page<GetTestAccountsRespDto> getTestAccounts(Page<GetTestAccountsRespDto> page, GetTestAccountsReqDto dto);
}




