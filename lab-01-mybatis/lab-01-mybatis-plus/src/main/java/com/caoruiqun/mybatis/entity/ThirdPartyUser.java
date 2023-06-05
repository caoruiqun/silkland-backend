package com.caoruiqun.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author caoruiqun
 * @date 2023/5/30 16:23
 * @desc:
 */
@Data
@TableName("sys_u_third_party_user")
public class ThirdPartyUser implements Serializable {
//    private static final long serialVersionUID = -2879267826517687597L;

    @TableId(value = "UID", type = IdType.ASSIGN_ID)
    private String uid;

    /**
     * 应用ID 索引
     */
    private String applicationUid;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 是否允许登录
     */
    private Integer allowLogin;
}
