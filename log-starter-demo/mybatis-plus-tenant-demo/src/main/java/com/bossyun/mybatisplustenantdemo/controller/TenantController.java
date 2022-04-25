package com.bossyun.mybatisplustenantdemo.controller;

import com.bossyun.mybatisplustenantdemo.context.TenantContextHolder;
import com.bossyun.mybatisplustenantdemo.dao.SysUserDao;
import com.bossyun.mybatisplustenantdemo.entity.SysUserEntity;
import com.bossyun.mybatisplustenantdemo.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TenantController {
    @Resource
    private SysUserDao sysUserDao;

    @GetMapping("/tenant")
    public String getTenant(){
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setCompany("23232");
        sysUserEntity.setUsername("123123");
        sysUserEntity.setPassword("asd");
        sysUserEntity.setEnabled(1);
        sysUserEntity.setType("dggg");
        sysUserEntity.setIsDel("0");
        int insert = sysUserDao.insert(sysUserEntity);
        return TenantContextHolder.getTenant();
    }

}
