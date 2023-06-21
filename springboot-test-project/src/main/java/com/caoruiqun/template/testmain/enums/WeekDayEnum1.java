package com.caoruiqun.template.testmain.enums;

/**
 * @author caoruiqun
 * @date 2023/6/19 16:49
 * @desc:
 */
public enum WeekDayEnum1 {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日"),
    ;
    private String name;

    private WeekDayEnum1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
