package com.bossyun.redissondemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.bossyun.redissondemo.dao")
public class RedissonDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonDemoApplication.class, args);
    }

}
