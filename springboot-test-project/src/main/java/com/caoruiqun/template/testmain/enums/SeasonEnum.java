package com.caoruiqun.template.testmain.enums;

/**
 * @author caoruiqun
 * @date 2023/6/19 17:05
 * @desc:
 */
public enum SeasonEnum {
    SPRING("春", 1), SUMMER("夏", 2), AUTUMN("秋", 3), WINTER("冬", 4);

    private final String name;
    private final int index;

    SeasonEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public static SeasonEnum getByIndex(int index) {
        for (SeasonEnum season : values()) {
            if (season.getIndex() == index) {
                return season;
            }
        }
        throw new IllegalArgumentException("Invalid index: " + index);
    }
}
