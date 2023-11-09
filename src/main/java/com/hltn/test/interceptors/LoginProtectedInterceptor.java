package com.hltn.test.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hltn.test.service.UserService;
import com.hltn.test.utils.JwtHelper;
import com.hltn.test.utils.Result;
import com.hltn.test.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
@Slf4j
/**
 *  未处理多处登录token过期
 */
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入登录状态拦截器");
        String token = request.getHeader("token");
        Long user_id = jwtHelper.getUserId(token);
        String userToken = userService.getToken(user_id); //数据库中的token
        boolean equal = userToken.equals(token);
        boolean expiration = jwtHelper.isExpiration(token);
        if(!expiration && equal){
            return true;
        }
        Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
        return false;
    }
}
