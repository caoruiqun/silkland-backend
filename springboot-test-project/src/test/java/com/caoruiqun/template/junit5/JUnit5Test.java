package com.caoruiqun.template.junit5;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author caoruiqun
 * @date 2023/6/29 16:49
 * @desc:
 */
@SpringBootTest
public class JUnit5Test {

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("**********测试开始**********");
    }

    @BeforeEach
    public void testBeforeEach(){
        System.out.println("测试即将开始--->");
    }

    @RepeatedTest(value = 2)
    @DisplayName("测试 @DisplayName()")
    @Test
    public void testDisplayName(){
        System.out.println("这是 @DisplayName()的测试！");
    }

    @DisplayName("测试 2-@DisplayName()")
    @Test
    public void testDisplayName2(){
        System.out.println("这是 2-@DisplayName()的测试！");
    }



}
