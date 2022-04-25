package com.bossyun.redissondemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bossyun.redissondemo.dao.SysUserDao;
import com.bossyun.redissondemo.entity.SysUserEntity;
import com.bossyun.redissondemo.redisson.lock.DistributedLocker;
import org.redisson.api.RLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisDistributedLockController {
    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private DistributedLocker distributedLocker;
    @GetMapping("/test")
    public void incre() {
        RLock test = distributedLocker.lock("test");
        System.out.println(Thread.currentThread().getName()+"获得锁");
        try{
            Thread.sleep(10);
            LambdaQueryWrapper<SysUserEntity> val = new QueryWrapper<SysUserEntity>().lambda()
                    .eq(SysUserEntity::getId, 1);
            SysUserEntity sysUserEntity = sysUserDao.selectOne(val);
            if(sysUserEntity.getNum() > 0){
                Integer num = sysUserEntity.getNum();
                num--;
                sysUserEntity.setNum(num);
            }
            sysUserDao.updateById(sysUserEntity);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放锁");
            distributedLocker.unlock(test);
        }
    }
}
