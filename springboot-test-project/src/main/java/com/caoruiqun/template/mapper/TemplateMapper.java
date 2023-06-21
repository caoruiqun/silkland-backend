package com.caoruiqun.template.mapper;

import com.caoruiqun.template.model.entity.UserInfo;
import com.caoruiqun.template.model.resquest.TemplateRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:05
 * @desc:
 */
@Mapper
public interface TemplateMapper {

    @Select("SELECT * FROM t_user_info")
    List<UserInfo> selectAll();

    @Insert("INSERT INTO t_user_info(name,age,create_time) VALUES(#{name},#{age},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUserInfo(UserInfo userInfo);

    @Update("UPDATE t_user_info SET name=#{name} WHERE id=#{id}")
    int updateUserInfoById(UserInfo userInfo);

    @Delete("DELETE FROM t_user_info WHERE id=#{id}")
    int deleteUserInfoById(Integer id);
}
