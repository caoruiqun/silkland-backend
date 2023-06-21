package com.caoruiqun.template.model.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author caoruiqun
 * @date 2023/5/26 16:39
 * @desc:
 */
@Data
public class UserInfo {

    private Integer id;

    private String name;

    private Integer age;

    private Date createTime;
}
