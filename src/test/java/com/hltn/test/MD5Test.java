package com.hltn.test;

import com.hltn.test.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MD5Test {
    @Autowired
    private MD5Util md5Util;
    @Test
    public void test(){
       String password = MD5Util.encrypt("123456");
        System.out.println(password);
    }
}
