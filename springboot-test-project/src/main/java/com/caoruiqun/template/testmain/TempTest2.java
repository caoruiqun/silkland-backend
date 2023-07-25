package com.caoruiqun.template.testmain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author caoruiqun
 * @date 2023/6/29 9:41
 * @desc:
 */
public class TempTest2 {

    @Test
    public void test01() {
        String fromExp = "";
        String[] fromExpArr = fromExp.split("\\.");
        String s = fromExpArr[0];
        System.out.println("s = " + s);

        String str = "str";
        boolean equals = str.equals(s);
        System.out.println("equals = " + equals);

        List<String> list = Arrays.asList(str);
        Optional<String> first = list.stream().filter(item -> item.equals(s)).findFirst();
        System.out.println("first = " + first);

        String s1 = first.orElse("no value");
        System.out.println("s1 = " + s1);

        // String[] arr = new String[0];
        String[] arr = new String[]{""};
        System.out.println("arr = " + arr);
        String s2 = arr[0];
        System.out.println("s2 = " + s2);


    }


}
