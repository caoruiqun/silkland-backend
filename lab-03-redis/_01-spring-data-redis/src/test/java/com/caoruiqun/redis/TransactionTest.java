package com.caoruiqun.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
//@EnableTransactionManagement
public class TransactionTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    @Transactional
    public void test01() {
        // 这里是偷懒，没在 RedisConfiguration 配置类中，设置 stringRedisTemplate 开启事务。
        stringRedisTemplate.setEnableTransactionSupport(true);

        // 执行想要的操作
        stringRedisTemplate.opsForValue().set("yunai:1", "shuai");
        stringRedisTemplate.opsForValue().set("yudaoyuanma:1", "dai");
    }

    @Test
    public void test02() {
        stringRedisTemplate.setEnableTransactionSupport(true);


        stringRedisTemplate.opsForValue().get("user:1");
        stringRedisTemplate.opsForValue().get("user:2");
    }

}
