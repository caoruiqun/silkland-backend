package com.caoruiqun.mybatis.mapper;

import com.caoruiqun.mybatis.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caoruiqun
 * @since 2023-06-03
 */
@Mapper
public interface UserMapper {

//    @Insert("INSERT INTO sys_c_user(name,age,create_time) VALUES(#{name},#{age},#{createTime})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="ID")
//    int insertOne(User userDO);

    @Insert("INSERT INTO sys_c_user(id,name,age,create_time) VALUES(#{id},#{name},#{age},#{createTime})")
    int insertOne(User userDO);
}
