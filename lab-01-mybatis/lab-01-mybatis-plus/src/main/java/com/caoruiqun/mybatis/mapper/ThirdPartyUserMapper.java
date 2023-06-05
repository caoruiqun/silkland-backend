package com.caoruiqun.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.caoruiqun.mybatis.entity.ThirdPartyUser;
import com.caoruiqun.mybatis.mapper.sqlprovider.BaseSqlProvider;
import com.caoruiqun.mybatis.mapper.sqlprovider.ThirdPartyUserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/30 16:47
 * @desc:
 */
@Mapper
public interface ThirdPartyUserMapper<E> extends BaseMapper<ThirdPartyUser> {
    @InsertProvider(type = ThirdPartyUserSqlProvider.class,method = "insertBatch")
    int insertBatch(@Param("list") List<ThirdPartyUser> list);

    @InsertProvider(type = BaseSqlProvider.class, method = "insertBatch")
//    @Options(keyProperty = "uid",keyColumn = "UID",useGeneratedKeys = true)
    int insertBatch2(Collection<E> list, String tableName);

    @Select("select * from sys_u_third_party_user")
    List<ThirdPartyUser> selectAll();

//    @Update("UPDATE sys_u_third_party_user SET ALLOW_LOGIN=#{disable} WHERE uid in " +
//            "<foreach " +
//            "collection=\"ids\" index=\"index\" item=\"id\" open=\"(\" close=\")\" separator=\",\"> \n" +
//            "   #{id} \n" +
//            "</foreach>")
    @Update({"<script>",
            "update sys_u_third_party_user set ALLOW_LOGIN=#{status} where uid in ",
            "<foreach collection=\"uids\" item=\"uid\" index=\"index\" open=\"(\" separator=\",\" close=\")\">",
            "#{uid}",
            "</foreach>",
            "</script>"})
    int testUpdateBatchByUids(@Param("uids") List<String> uids,@Param("status") int status);
}
