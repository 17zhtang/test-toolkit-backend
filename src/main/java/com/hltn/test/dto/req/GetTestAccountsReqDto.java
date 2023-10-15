package com.hltn.test.dto.req;

import lombok.Data;

import java.util.Date;
@Data
public class GetTestAccountsReqDto {

    private String account;

    private Integer environment;

    private String detail;

    private String creator;

    private Integer currentPage = 1;


    private Integer pageSize = 10;
}
