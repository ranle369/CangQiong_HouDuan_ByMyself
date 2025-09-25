package com.myself.interceptor;

import constant.JwtConstant;
import property.JwtProperty;
import util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import util.ThreadLocalUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperty jwtProperty;

    /**
     *
     * @param request   请求参数在其中
     * @param response  返回数据
     * @param handler   请求来的方法路径
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("开始执行拦截处理方案");
//      不是动态方法就放行
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        String token = request.getHeader(jwtProperty.getAdminTokenName());

        try {
            Claims jwt = JwtUtil.parseJWT(jwtProperty.getAdminSecretKey(), token);
            log.info("jwt解析成功");
            ThreadLocalUtil.setData(jwt.get(JwtConstant.EMP_ID).toString());
            return true;
        }catch (Exception e){
            log.info("jwt解析失败");
            return false;
        }


    }
}
