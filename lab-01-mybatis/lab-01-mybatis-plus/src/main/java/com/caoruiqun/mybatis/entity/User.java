package com.caoruiqun.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author caoruiqun
 * @since 2023-06-03
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_c_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;

    /**
     * 状态
     */
    @TableField("STATUS")
    private Integer status;

    /**
     * 是否删除
     */
    @TableField("DELETED")
    @TableLogic
    private Integer deleted;

    /**
     * 是否有效
     */
    @TableField("IS_VALID")
    private Integer isValid;

    /**
     * 创建人
     */
    @TableField("CREATE_BY")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 流水号
     */
    @TableField("FLOW_NO")
    private Long flowNo;
}
