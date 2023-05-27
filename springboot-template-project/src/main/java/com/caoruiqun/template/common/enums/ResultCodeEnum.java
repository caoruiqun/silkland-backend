package com.caoruiqun.template.common.enums;

import lombok.Data;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:44
 * @desc:
 */
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    BAD_REQUEST(400,"请求报文语法错误或参数错误"),
    UNAUTHORIZED(401, "token不存在或已失效"),
    FORBIDDEN(403,"请求资源被拒绝（没有权限）"),
    NOT_FOUND(404,"未找到资源"),
    SYSTEM_ERROR(500, "系统异常"),
    ;

    private Integer code;

    private String name;

    ResultCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
