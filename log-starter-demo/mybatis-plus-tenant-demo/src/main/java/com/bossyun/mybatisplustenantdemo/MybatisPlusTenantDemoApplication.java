package com.bossyun.mybatisplustenantdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bossyun.mybatisplustenantdemo.dao")
public class MybatisPlusTenantDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusTenantDemoApplication.class, args);
    }

}
