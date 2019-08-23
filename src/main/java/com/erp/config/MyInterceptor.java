package com.erp.config;

import com.erp.Util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author  chao.wang
 * 自定义拦截器,将当前的类定义成组件
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${auth.header}") //application.yml 获取auth.header的值
    private String header;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //判断token是否有效，有效则返回true 无效返回false
        boolean flag;
        String token= request.getHeader(header);
        if (token!=null){
            //token有效，允许访问相关方法
            Claims claims=jwtTokenUtil.parseJWT(token);
            System.out.println(claims.getIssuer());
           flag=true;
        }else{
            //token无效，重定向
            flag=false;

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("进入了postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("进入了afterCompletion");
    }



}
