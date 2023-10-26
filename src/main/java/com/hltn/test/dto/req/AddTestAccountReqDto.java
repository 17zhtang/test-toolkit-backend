package com.hltn.test.dto.req;

import lombok.Data;

@Data
public class AddTestAccountReqDto {
    private String account;

    private Integer environment;

    private String detail;

    private Long creatorId;
}
