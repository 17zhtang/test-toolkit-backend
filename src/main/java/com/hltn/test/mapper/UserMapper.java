package com.hltn.test.mapper;

import com.hltn.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 18749
* @description 针对表【user(用户表)】的数据库操作Mapper
* @createDate 2023-10-03 19:19:01
* @Entity com.hltn.test.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
    public int setToken(@Param("uid") Long uid, @Param("token") String token);

    public String getToken(@Param("uid") Long uid);
}




