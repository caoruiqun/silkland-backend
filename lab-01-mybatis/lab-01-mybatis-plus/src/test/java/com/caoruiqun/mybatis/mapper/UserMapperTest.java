package com.caoruiqun.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.caoruiqun.mybatis.Application;
import com.caoruiqun.mybatis.common.util.IdentifierUtils;
import com.caoruiqun.mybatis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
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
        Long id = IdentifierUtils.getNextIdOfNumber();

        User userDO = new User();
        userDO.setName("tom")
                .setAge(36)
                .setCreateTime(LocalDateTime.now())
                .setId(id);
        int count = userMapper.insert(userDO);
        log.debug("userMapper.insertOne: {}", count);

        System.out.println("id = " + id);
    }

    @Test
    public void test02() {
        List<String> list = Arrays.asList("1", "2", "3");
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println("users = " + users);
    }

    @Test
    public void test03() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.in(User::getId, Arrays.asList("1", "2"));
        wrapper.in(User::getName, Arrays.asList("jack", "tom"));
        List<User> users = userMapper.selectList(wrapper);
        System.out.println("users_03 = " + users);
    }

    //---------------UPDATE-----------------

    /**
     * 第一种：主键updateById
     */
    @Test
    public void testUpdate01() {
        User userDO = new User();
        userDO.setName("helen")
                .setAge(16)
                .setCreateTime(LocalDateTime.now())
                .setId(1L);
        int i = userMapper.updateById(userDO);
        System.out.println("i = " + i);
    }

    /**
     * 第二种:通过实体类筛选进行update
     */
    @Test
    public void testUpdate02() {
        // 作为查询条件
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("id", "1");
        //new出来的对象作为修改值
        User userDO = new User();
        userDO.setName("mary02")
                .setAge(19);
        int update = userMapper.update(userDO, wrapper);
        System.out.println("update = " + update);
    }

    /**
     * 第三种：通过lambdaUpdateWrapper进行update
     */
    @Test
    public void testUpdate03() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        //eq是指你查询的条件，set是指你修改的值
        wrapper.eq(User::getId, "1")
                .set(User::getName, "Lily02")
                .set(User::getAge, 88);
        int update = userMapper.update(null, wrapper);
        System.out.println("update = " + update);
    }

    /**
     * 设置某个字段值为null
     */
    @Test
    public void testUpdate04() {
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        //eq是指你查询的条件，set是指你修改的值
        wrapper.eq(User::getId, "1")
                .set(User::getName, null)
                .set(User::getAge, null);
        int update = userMapper.update(null, wrapper);
        System.out.println("update = " + update);
    }

}
