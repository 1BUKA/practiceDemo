package com.bossyun.redissondemo;

import com.bossyun.redissondemo.redisson.lock.DistributedLocker;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class RedissonDemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }

}
