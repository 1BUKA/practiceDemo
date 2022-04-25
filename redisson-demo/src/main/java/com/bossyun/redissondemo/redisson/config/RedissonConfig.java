package com.bossyun.redissondemo.redisson.config;

import com.bossyun.redissondemo.redisson.RedissonProperties;
import com.bossyun.redissondemo.redisson.lock.DistributedLocker;
import com.bossyun.redissondemo.redisson.lock.RedissonDistributedLocker;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * redisson配置 集群版的redissson锁
 */
@Configuration
public class RedissonConfig {
    @Resource
    private RedissonProperties redissonProperties;

    @Bean
    public RedissonClient getRedisson(){
        Optional<String[]> nodes = getNodes(redissonProperties.getNodes());
        if(!nodes.isPresent()){
            throw new NullPointerException("nodes 配置有问题");
        }
        Config config = getConfig(nodes.get(), redissonProperties.getPassword());
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }

    /**
     * 获取集群节点数据
     * @return 拼接的节点数据
     */
    private Optional<String[]> getNodes(List<String> nodes){
        if(nodes.size() <= 0){
            return Optional.empty();
        }
        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
        for (int i = 0; i < nodes.size(); i++) {
            String node = "redis://" + nodes.get(i);
            nodes.set(i, node);
        }
        String[] nodeArray = nodes.toArray(new String[nodes.size()]);
        return Optional.of(nodeArray);
    }

    /**
     * 获取redisson配置
     * @param nodes 节点数据
     * @param password 密码
     * @return redisson配置
     */
    private Config getConfig(String[] nodes, String password){
        Config config = new Config();
        config.useClusterServers() //这是用的集群server
                .setScanInterval(2000) //设置集群状态扫描时间
                .addNodeAddress(nodes)
                .setPassword(password);
        return config;
    }
    @Bean
    public DistributedLocker distributedLocker(RedissonClient redissonClient) {
        return new RedissonDistributedLocker(redissonClient);
    }

}