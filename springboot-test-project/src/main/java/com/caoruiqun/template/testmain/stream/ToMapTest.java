package com.caoruiqun.template.testmain.stream;

import com.caoruiqun.template.model.stream.Student;
import com.caoruiqun.template.model.stream.Teacher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author caoruiqun
 * @date 2023/6/14 13:28
 * @desc: Java：List转Map （用stream实现）
 */
public class ToMapTest {

    /**
     * 一、List<Object> 转 Map<String, String>
     */
    @Test
    public void test01() {

        // 声明一个List集合
        List<Student> list = new ArrayList<>();
        list.add(new Student("1001", "小A"));
        list.add(new Student("1001", "小B")); //学号重复（下面特殊处理）
        list.add(new Student("1002", "小C"));
        list.add(new Student("1003", "小D"));

        // 将list转map 【key为1个属性,value为1个属性】  （map的键重复不会报错，下面已经处理）
        Map<String, String> map =
                list.stream().collect(Collectors.toMap(
                        Student::getNo,
                        Student::getName,
                        (key1, key2) -> key1
                ));
        System.out.println("map = " + map);

        // 将list转map 【key为多个属性,value为1个属性】  （map的键重复不会报错，下面已经处理）
        Map<String, String> map1 =
                list.stream().collect(Collectors.toMap(
                        obj -> obj.getNo() + "_" + obj.getName(),
                        Student::getName,
                        (key1, key2) -> key1
                ));
        System.out.println("map1 = " + map1);

    }

    /**
     * 二、List<Object> 转 Map<String, Object> (返回对象本身)
     */
    @Test
    public void test02() {

        //声明一个List集合
        List<Student> list = new ArrayList<>();
        list.add(new Student("1001", "小A"));
        list.add(new Student("1001", "小B"));
        list.add(new Student("1002", "小C"));
        list.add(new Student("1003", "小D"));

        //将list转map 【key为1个属性,value为对象本身】  （map的键去重）
        Map<String, Student> map =
                list.stream().collect(Collectors.toMap(
                        Student::getNo,
                        obj -> obj,
                        (key1, key2) -> key1
                ));
        System.out.println("map = " + map);

//        或者

        //将list转map 【key为1个属性,value为对象本身】  （map的键去重）
        Map<String, Student> map1 =
                list.stream().collect(Collectors.toMap(
                        Student::getNo,
                        Function.identity(),
                        (key1, key2) -> key1
                ));
        System.out.println("map1 = " + map1);

//        或者

        //将list转map 【key为多个属性,value为对象本身】 （map的键去重）
        Map<String, Student> map2 =
                list.stream().collect(Collectors.toMap(
                        obj -> obj.getNo() + "_" + obj.getName(),
                        obj -> obj,
                        (key1, key2) -> key1
                ));
        System.out.println("map2 = " + map2);

    }

    /**
     * 三、List<Object1> 转 Map<String, Object2> (返回另一个对象)
     */
    @Test
    public void test03() {

        //声明一个List集合
        List<Student> list = new ArrayList();
        list.add(new Student("1001", "小A"));
        list.add(new Student("1001", "小B"));
        list.add(new Student("1002", "小C"));
        list.add(new Student("1003", "小D"));

        //将list转map 【key为1个属性,value为另一个对象】 （map的键去重）
        Map<String, Teacher> map =
                list.stream().collect(Collectors.toMap(
                        Student::getNo,
                        stu -> {
                            Teacher teacher = new Teacher();
                            teacher.setNo(stu.getNo());
                            teacher.setName(stu.getName());
                            return teacher;
                        },
                        (key1, key2) -> key1
                ));
        System.out.println("map = " + map);

    }

    /**
     * 四、List<Object> 转 Map<String, List<Object>> (分组)【以1个字段分/以多个字段分】
     */
    @Test
    public void test04() {

        //声明一个List集合
        List<Student> list = new ArrayList<>();
        list.add(new Student("1001", "小A"));
        list.add(new Student("1001", "小B"));
        list.add(new Student("1002", "小C"));
        list.add(new Student("1003", "小D"));

        //将list转map  【key为1个属性,value为相同key的集合】 （以某1个属性来分组，将分组后相同的对象放在一起）
        Map<String, List<Student>> map =
                list.stream().collect(Collectors.groupingBy(Student::getNo));
        System.out.println("map = " + map);

        //将list转map 【key为多个属性,value为相同key的集合】 （以多个属性来分组，将分组后相同的对象放在一起）
        Map<String, List<Student>> map1 =
                list.stream().collect(Collectors.groupingBy(obj -> obj.getNo() + "_" + obj.getName()));
        System.out.println("map1 = " + map1);

    }

}
