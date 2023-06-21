package com.caoruiqun.mybatis.util;

import java.net.InetAddress;

/**
 * @author caoruiqun
 * @date 2023/6/21 16:59
 * @desc:
 */
public class DefaultIdentifierGenerator {
    private final Sequence sequence;

    public DefaultIdentifierGenerator() {
        this.sequence = new Sequence((InetAddress)null);
    }

    public Long nextId(Object entity) {
        return this.sequence.nextId();
    }

}

