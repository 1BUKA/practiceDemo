package com.bossyun.log.controller;

import com.bossyun.log.annotation.AuditLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @AuditLog(operation = "demotest")
    @GetMapping("/demo")
    public String getStr(){
        return "bingo";
    }
}
