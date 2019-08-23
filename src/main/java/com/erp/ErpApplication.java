package com.erp;

import com.erp.mapper.AdminMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.erp.mapper")
@EnableCaching//允许缓存数据
public class ErpApplication {
    @Autowired
    private AdminMapper am;
    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

}
