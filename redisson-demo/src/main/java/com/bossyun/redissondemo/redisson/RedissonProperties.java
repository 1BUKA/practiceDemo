package com.bossyun.redissondemo.redisson;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ToString
@Component
@ConfigurationProperties(prefix = "bsy.redis.cluster")
public class RedissonProperties {
    /**
     * 节点列表：IP：port
     */
    private List<String> nodes;
    /**
     * 密码
     */
    private String password;
}
