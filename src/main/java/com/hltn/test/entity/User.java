package com.hltn.test.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    @TableId
    private Long id;

    private String account;

    private String password;

    private String username;

    private Long groupId;

    private String avatar;

    private String token;

    private Date createTime;

    private Date updateTime;
    @TableLogic
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}
