package com.hltn.test.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hltn.test.dto.req.GetTestAccountsReqDto;
import com.hltn.test.dto.resp.GetTestAccountsRespDto;
import com.hltn.test.entity.TestAccount;
import com.hltn.test.service.TestAccountService;
import com.hltn.test.mapper.TestAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 18749
* @description 针对表【test_account(测试账号表)】的数据库操作Service实现
* @createDate 2023-10-15 23:25:59
*/
@Service
public class TestAccountServiceImpl extends ServiceImpl<TestAccountMapper, TestAccount>
    implements TestAccountService{

    @Autowired
    TestAccountMapper testAccountMapper;
    @Override
    public Page<GetTestAccountsRespDto> getTestAccounts(GetTestAccountsReqDto dto) {
        Page<GetTestAccountsRespDto> page = new Page<>(dto.getCurrentPage(),dto.getPageSize());
        Page<GetTestAccountsRespDto> testAccounts =  testAccountMapper.getTestAccounts(page,dto);

        return testAccounts;

    }
}




