package com.caoruiqun.template.testmain.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/6/8 8:56
 * @desc:
 */
@Slf4j
public class ListTest {

    /**
     * @Desc: java字符串分割为数组
     */
    @Test
    public void test01() {

        String str = "123,456,789";
        String[] split = str.split(",");
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));

//        Arrays.asList(split).forEach(s -> System.out.println(s));
//        Stream.of(split).forEach(System.out::println);
//        Arrays.stream(split).forEach(System.out::println);

    }

    /**
     * @Desc: 数组转List集合
     */
    @Test
    public void test02() {

        String[] split = {"123", "456", "789"};
        List<String> list = Arrays.asList(split);
        System.out.println("list = " + list);

    }

    /**
     * @Desc: 判断list中是否包含某元素
     */
    @Test
    public void test03() {

        String[] split = {"123", "456", "789"};
        List<String> list = Arrays.asList(split);
        boolean contains = list.contains("123");
        System.out.println("contains = " + contains);

        boolean contains1 = list.contains("xxx");
        System.out.println("contains1 = " + contains1);

        boolean contains2 = list.contains(null);
        System.out.println("contains2 = " + contains2);

    }

    /**
     * @Desc: 判断list中是否包含某元素
     */
    @Test
    public void test04() {

        String[] split = {"123", "456", "789"};
        List<String> list = Arrays.asList(split);
//        list.remove("123");
//        System.out.println("list = " + list);

        List<String> arrayList = new ArrayList<>(list);
        arrayList.remove("123");
        System.out.println("arrayList = " + arrayList);
        System.out.println("list = " + list);

    }

}
