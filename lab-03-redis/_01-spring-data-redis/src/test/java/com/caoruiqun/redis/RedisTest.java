package com.caoruiqun.redis;

import com.caoruiqun.redis.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @author caoruiqun
 * @date 2023/6/8 13:46
 * @desc:
 */
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

//    @Autowired
//    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void test01() {
        boolean increment = redisUtil.increment("no");
        System.out.println("increment = " + increment);

//        Long no = redisTemplate.opsForValue().increment("no");
//        System.out.println("no = " + no);
    }

    @Test
    void test02() {
        String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        Long no = redisTemplate.opsForValue().increment("broadcast_no");

        String format = String.format("%03d", no);
        System.out.println("format = " + year +format);
    }
}
