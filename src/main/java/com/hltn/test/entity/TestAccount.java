package com.hltn.test.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName test_account
 */
@TableName(value ="test_account")
@Data
public class TestAccount implements Serializable {
    @TableId
    private Long id;

    private String account;

    private Integer environment;

    private String detail;

    private Long creatorId;

    private Date createTime;

    private Date updateTime;

    private Integer isDeleted;

    @TableLogic
    private static final long serialVersionUID = 1L;
}