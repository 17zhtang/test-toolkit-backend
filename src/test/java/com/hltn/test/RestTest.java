package com.hltn.test;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class RestTest {

    private RestTemplate restTemplate = new RestTemplate();
    @Test
    public void test(){
        String url = "https://user-sso-test.61info.cn/user/processLogin";
        String jsonString = "{\"account\":\"12300100100\",\"loginEnv\":1,\"password\":\"670b14728ad9902aecba32e22fa4f6bd\"}";
        JSONObject json = JSONUtil.toBean(jsonString, JSONObject.class);
        System.out.println(json);
        ResponseEntity<JSONObject> result = restTemplate.postForEntity(url, json, JSONObject.class);
        System.out.println(result);
        JSONObject body = result.getBody();
        System.out.println(body.getByPath("data.userToken"));
//        System.out.println(result.getBody());
//        System.out.println(result.getStatusCode());
//        System.out.println(result.getHeaders());
    }
}
