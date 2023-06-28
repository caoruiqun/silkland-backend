package com.caoruiqun.mybatis.mapper.sqlprovider;

import com.caoruiqun.mybatis.entity.User;
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
public class UserSqlProvider {

//    public String insertBatch(Map map) {
//        List<User> list = (List<User>) map.get("list");
//        StringBuilder sb = new StringBuilder();
//        sb.append("INSERT INTO sys_c_user ");
//        sb.append("(id, name, age, status) ");
//        sb.append("VALUES ");
//        MessageFormat mf = new MessageFormat("(#'{'list[{0}].id},#'{'list[{0}].name},#'{'list[{0}].age},#'{'list[{0}].status})");
//        for (int i = 0; i < list.size(); i++) {
//            sb.append(mf.format(new Object[]{i}));
//            if (i < list.size() - 1) {
//                sb.append(",");
//            }
//        }
//        return sb.toString();
//    }

    public String insertBatch(List<User> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO sys_c_user ");
        sb.append("(id, name, age, status) ");
        sb.append("VALUES ");
//        MessageFormat mf = new MessageFormat("(#'{'list[{0}].id},#'{'list[{0}].name},#'{'list[{0}].age},#'{'list[{0}].status})");
        MessageFormat mf = new MessageFormat("(" +
                "#'{'list[{0}].id}," +
                "#'{'list[{0}].name}," +
                "#'{'list[{0}].age}," +
                "#'{'list[{0}].status}" +
                ")");
        for (int i = 0; i < list.size(); i++) {
            sb.append(mf.format(new Object[]{i}));
            if (i < list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

}
