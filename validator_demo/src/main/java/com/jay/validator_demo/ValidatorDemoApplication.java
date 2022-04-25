package com.jay.validator_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ValidatorDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorDemoApplication.class, args);
    }

}
