package com.caoruiqun.mybatis.mapper.sqlprovider;

import com.caoruiqun.mybatis.entity.ThirdPartyUser;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @author caoruiqun
 * @date 2023/5/30 17:12
 * @desc:
 */
@Slf4j
public class ThirdPartyUserSqlProvider {

    public String insertBatch(Map map) {
        List<ThirdPartyUser> list = (List<ThirdPartyUser>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO sys_u_third_party_user ");
        sb.append("(uid, application_uid, user_id, allow_login) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].uid},#'{'list[{0}].applicationUid},#'{'list[{0}].userId},#'{'list[{0}].allowLogin})");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
