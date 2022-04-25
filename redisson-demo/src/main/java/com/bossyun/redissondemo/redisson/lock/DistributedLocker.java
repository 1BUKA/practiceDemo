package com.bossyun.redissondemo.redisson.lock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁顶层接口
 */
public interface DistributedLocker {
    public RLock lock(String lockKey);

    public RLock lock(String lockKey, long leaseTime);

    public RLock lock(String lockKey, TimeUnit unit, long timeout);

    public boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    public void unlock(String lockKey);

    public void unlock(RLock lock);

}
