package com.bossyun.mybatisplustenantdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bossyun.mybatisplustenantdemo.dao.SysUserDao;
import com.bossyun.mybatisplustenantdemo.entity.SysUserEntity;
import com.bossyun.mybatisplustenantdemo.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {
}
