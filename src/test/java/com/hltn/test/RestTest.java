package com.hltn.test;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

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

    @Test
    public void test2(){
        String url = "https://eolink.o.apispace.com/456456/weather/v001/now?areacode=101010100&lonlat=116.407526,39.904030";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization-Type","apikey");
        headers.set("X-APISpace-Token", "4a8g1in5ipwrqjr47782enkz76tra87l");


        HttpEntity<JSONObject> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET,requestEntity,JSONObject.class);

        System.out.println(response);
    }

    @Test
    public void test3(){
        String url = "https://eolink.o.apispace.com/postcode/addr";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization-Type","apikey");
        headers.set("X-APISpace-Token", "4a8g1in5ipwrqjr47782enkz76tra87l");
        headers.set("Content-Type","application/x-www-form-urlencoded");

        String jsonString = "{\"postcode\":\"511400\",\"pageSize\":\"1\"}";
        JSONObject json = JSONUtil.toBean(jsonString, JSONObject.class);

        MultiValueMap<String,Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("postcode",511400);
        params.add("pageSize",1);

        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(params,headers);
        System.out.println(requestEntity);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,String.class);

        String result = response.getBody();
        JSONObject body = JSONUtil.toBean(result, JSONObject.class);
        System.out.println(response);
        System.out.println(body);
        Object list= body.getByPath("result.list[0].PostNumber");
        System.out.println(list);

    }

    @Test
    public void test4(){
        long time1 = System.currentTimeMillis();
        long time2 = new Date().getTime();
        System.out.println(time1);
        System.out.println(time2);
    }
}