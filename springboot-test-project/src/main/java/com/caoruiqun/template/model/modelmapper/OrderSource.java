package com.caoruiqun.template.model.modelmapper;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author caoruiqun
 * @date 2023/6/17 11:44
 * @desc:
 */
public enum OrderSource {

    Mobile("1", "移动端"),
    Web("2", "网页端"),
    Other("3", "其他");
    private String type;
    private String message;

    OrderSource(){

    }

    OrderSource(String type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * 枚举转Map
     */
    private static Map<String, OrderSource> map = Stream.of(OrderSource.values()).collect(Collectors.toMap(OrderSource::getType, Function.identity(), (v1, v2) -> v1));

    public static OrderSource getInstance(String type){
        return map.get(type);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
