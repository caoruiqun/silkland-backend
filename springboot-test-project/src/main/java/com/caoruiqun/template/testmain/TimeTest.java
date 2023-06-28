package com.caoruiqun.template.testmain;

import org.junit.Test;

/**
 * @author caoruiqun
 * @date 2023/6/20 17:05
 * @desc:
 */
public class TimeTest {


    @Test
    public void test01() {
        String timestamp = "1687253244";
        Long time = System.currentTimeMillis() / 1000;
        System.out.println("time = " + time);
        if (Math.abs(Long.parseLong(timestamp)-time) > 2 * 60) {
            System.out.println("time 2222= " + time);
        }
    }

}
