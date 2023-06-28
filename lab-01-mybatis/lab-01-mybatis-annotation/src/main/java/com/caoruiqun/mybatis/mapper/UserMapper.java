package com.caoruiqun.mybatis.mapper;

import com.caoruiqun.mybatis.entity.User;
import com.caoruiqun.mybatis.mapper.sqlprovider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

//    @Select({"<script>",
//            "select * from sys_c_user where id in ",
//            "<foreach collection=\"list\" item=\"id\" index=\"index\" open=\"(\" separator=\",\" close=\")\">",
//            "#{id}",
//            "</foreach>",
//            "</script>"})
//    List<User> selectByIds(@Param("list") List<String> list);

//    @Select("<script>"
//            + "SELECT * FROM table WHERE OrderNo IN "
//            + "<foreach item='item' index='index' collection='list'      open='(' separator=',' close=')'>"
//            + "#{item}"
//            + "</foreach>"
//            + "</script>")
//    List<User> selectByIds(@Param("list") List<String> list);

    @Select({"<script>",
            "select * from sys_c_user where id in ",
            "<foreach collection='list' item='id' index='index' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    List<User> selectByIds(@Param("list") List<String> list);

    @Update({"<script>",
            "update sys_c_user set STATUS=#{status} where ID in ",
            "<foreach collection='list' item='id' index='index' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    int updateByIds(@Param("list") List<String> list, @Param("status")  int i);

    @InsertProvider(type = UserSqlProvider.class,method = "insertBatch")
    int insertBatch(@Param("list") List<User> list);
}
