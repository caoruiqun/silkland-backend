package com.caoruiqun.mybatis.common.util;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;

/**
 * @Auther: xiaoyu
 * @Date: 2023/3/2 19:15
 * @Descripton:
 */
public class IdentifierUtils {

    private static final DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();

    public static String getNextAssignId(){
        return String.valueOf(defaultIdentifierGenerator.nextId(null));
    }


}
