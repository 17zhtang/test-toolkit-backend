package com.hltn.test.dto.resp;

import lombok.Data;

import java.util.Date;

@Data
public class GetTestAccountsRespDto {
    private Long id;

    private String account;

    private Integer environment;

    private String detail;

    private Long creatorId;

    private String creator;


}
