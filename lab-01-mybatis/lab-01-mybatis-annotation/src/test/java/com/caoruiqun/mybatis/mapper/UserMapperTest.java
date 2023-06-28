package com.caoruiqun.mybatis.mapper;

import com.caoruiqun.mybatis.Application;
import com.caoruiqun.mybatis.entity.User;
import com.caoruiqun.mybatis.util.id.IdWorkerUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test02() {
        List<String> list = Arrays.asList("1", "2", "1673616148381728769");
        List<User> users = userMapper.selectByIds(list);
        System.out.println("users = " + users);
    }

    /**
     * 批量更新
     */
    @Test
    public void test03() {
        List<String> list = Arrays.asList("1", "2", "1673616148381728769");
        int count = userMapper.updateByIds(list, 1);
        System.out.println("count = " + count);
    }

    /**
     * 批量插入
     */
    @Test
    public void test04() {
        List<User> userDOs = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User insertDO = new User();
            insertDO.setId(IdWorkerUtil.getNextId());
            insertDO.setName("ji "+i);
            insertDO.setAge(i+100);
            insertDO.setStatus(0);

            userDOs.add(insertDO);
        }
        int i = userMapper.insertBatch(userDOs);
        log.debug("userMapper.insertBatch: {}", i);
    }

}
