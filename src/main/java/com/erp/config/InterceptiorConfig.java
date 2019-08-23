package com.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截配置类
 */
@Configuration//声明为一个配置类
public class InterceptiorConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器，需要添加拦截器的实列对象
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createInertceptor())
                .addPathPatterns("/**")//所有的路劲，不限定路劲的层级关系
                .excludePathPatterns("/api/getAdmin","/api/img");//拦截器不会拦截的请求
    }

    /**
     * 返回拦截器的实列对象的方法
     * @return
     */

    @Bean
    public MyInterceptor createInertceptor(){
        return new MyInterceptor();
    }
}
