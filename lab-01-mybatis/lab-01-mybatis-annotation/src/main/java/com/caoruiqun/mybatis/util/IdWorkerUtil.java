package com.caoruiqun.mybatis.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author caoruiqun
 * @date 2023/6/21 16:42
 * @desc:
 */
public class IdWorkerUtil {

    private static final DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();

    public static String getNextAssignId(){
        return String.valueOf(defaultIdentifierGenerator.nextId(null));
    }

    public static Long getNextId(){
        return defaultIdentifierGenerator.nextId(null);
    }

    public static String get32UUID() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return (new UUID(random.nextLong(), random.nextLong())).toString().replace("-", "");
    }

}
