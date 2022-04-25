package com.jay.validator_demo.controller;

import com.jay.validator_demo.entity.CustomAnnotationEntity;
import com.jay.validator_demo.entity.ValidatorDemoEntity;
import org.apache.tomcat.jni.Local;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@RestController
public class ValidatorDemoController {

    @PostMapping("/checkParam")
    public String checkParam(@Validated @RequestBody ValidatorDemoEntity entity) {
        return "bingo";
    }

    @PostMapping("/checkCustomAnnotionParam")
    public String checkCustomAnnotionParam(@Validated @RequestBody CustomAnnotationEntity entity){
        return "bingo";
    }
    @GetMapping("/getJson")
    public ValidatorDemoEntity getUser(){
        ValidatorDemoEntity validatorDemoEntity = new ValidatorDemoEntity();
        validatorDemoEntity.setId(1l);
        validatorDemoEntity.setName("myNameMustNotBlakn");
        validatorDemoEntity.setAge(1);
        validatorDemoEntity.setEmail("123@qq.com");
        validatorDemoEntity.setStrLength("lengthBetweenZeroAndOneHandard");
        validatorDemoEntity.setNoNull("mustNoNull");
        validatorDemoEntity.setMustNull("mustNul");
        validatorDemoEntity.setFutureTime(LocalDateTime.now());
        validatorDemoEntity.setFutureOrPersentTime(LocalDateTime.now());
        validatorDemoEntity.setMustFalse(false);
        validatorDemoEntity.setMustTrue(true);
        validatorDemoEntity.setCreditCard(new BigDecimal("50"));
        validatorDemoEntity.setMyCard(new BigDecimal("50.00"));
        return validatorDemoEntity;
    }
}
