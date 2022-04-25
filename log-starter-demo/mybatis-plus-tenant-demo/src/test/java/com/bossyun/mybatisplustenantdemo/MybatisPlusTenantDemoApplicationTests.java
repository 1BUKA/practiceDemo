package com.bossyun.mybatisplustenantdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusTenantDemoApplicationTests {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from sys_user");
        for (Map<String, Object> map : maps) {
            map.forEach((k, v) -> System.out.println("k="+k+"\tv="+v));
        }
    }

}
