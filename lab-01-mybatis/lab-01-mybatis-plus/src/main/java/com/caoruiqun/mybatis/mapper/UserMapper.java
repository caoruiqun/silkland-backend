package com.caoruiqun.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caoruiqun.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caoruiqun
 * @since 2023-06-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
