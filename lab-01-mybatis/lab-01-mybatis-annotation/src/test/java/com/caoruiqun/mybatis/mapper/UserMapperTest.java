package com.caoruiqun.mybatis.mapper;

import com.caoruiqun.mybatis.Application;
import com.caoruiqun.mybatis.entity.User;
import com.caoruiqun.mybatis.util.IdWorkerUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@Slf4j
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test00() {

    }

    @Test
    public void test01() {
        Long id = IdWorkerUtil.getNextId();
//        Integer id = Integer.parseInt(String.valueOf(nextId));

        User userDO = new User();
        userDO.setName("jack1")
                .setAge(21)
                .setCreateTime(LocalDateTime.now())
                .setId(id);
        int count = userMapper.insertOne(userDO);
        log.debug("userMapper.insertOne: {}", count);

//        Integer id = userDO.getId();
        System.out.println("id = " + id);
    }
}
