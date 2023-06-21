package com.caoruiqun.template.testmain.enums;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caoruiqun
 * @date 2023/6/19 16:50
 * @desc:
 */
public class EnumTest {

    /**
     *
     public enum ColorEnumTest {
     RED, GREEN, BLANK;
     }
     然后我们再将上面的那段代码编译为字节码，具体内容如下：

     public final class ColorEnumTest extends java.lang.Enum<ColorEnumTest> {
     public static final ColorEnumTest RED;
     public static final ColorEnumTest GREEN;
     public static final ColorEnumTest BLANK;
     public static ColorEnumTest[] values();
     public static ColorEnumTest valueOf(java.lang.String);
     static {};
     }
     */
    @Test
    public void test01() {
        boolean workday = isWorkday(WeekDayEnum.TUESDAY);
        System.out.println("workday = " + workday);

        boolean workday1 = isWorkday(WeekDayEnum.FRIDAY);
        System.out.println("workday1 = " + workday1);

        boolean workday2 = isWorkday(WeekDayEnum.SUNDAY);
        System.out.println("workday2 = " + workday2);
    }

    @Test
    public void test02() {
        WeekDayEnum day = WeekDayEnum.MONDAY;
        System.out.println(day); // 输出MONDAY

        switch (day) {
            case MONDAY:
                System.out.println("今天是星期一");
                break;
            case TUESDAY:
                System.out.println("今天是星期二");
                break;
            case WEDNESDAY:
                System.out.println("今天是星期三");
                break;
            case THURSDAY:
                System.out.println("今天是星期四");
                break;
            case FRIDAY:
                System.out.println("今天是星期五");
                break;
            case SATURDAY:
                System.out.println("今天是星期六");
                break;
            case SUNDAY:
                System.out.println("今天是星期日");
                break;
        }
    }

    @Test
    public void test03() {
        WeekDayEnum1 day = WeekDayEnum1.MONDAY;
        System.out.println(day.getName()); // 输出星期一
    }

    @Test
    public void test04() {
        SeasonEnum byIndex = SeasonEnum.getByIndex(3);
        System.out.println("byIndex = " + byIndex);
        System.out.println("season = " + byIndex.getName());
    }

    @Test
    public void test05() {
        WeekDayEnum sunday = WeekDayEnum.valueOf("SUNDAY");
        System.out.println("sunday = " + sunday);
        WeekDayEnum[] values = WeekDayEnum.values();
        System.out.println("values = " + Arrays.toString(values));
    }



    public static boolean isWorkday(WeekDayEnum day) {
        switch (day) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return true;
            default:
                return false;
        }
    }

}
