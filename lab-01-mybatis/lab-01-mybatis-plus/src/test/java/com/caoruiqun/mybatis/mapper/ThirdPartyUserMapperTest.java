package com.caoruiqun.mybatis.mapper;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.caoruiqun.mybatis.Application;
import com.caoruiqun.mybatis.common.util.IdentifierUtils;
import com.caoruiqun.mybatis.entity.ThirdPartyUser;
import com.caoruiqun.mybatis.mapper.ThirdPartyUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest(classes = Application.class)
public class ThirdPartyUserMapperTest {

    @Autowired
    private ThirdPartyUserMapper thirdPartyUserMapper;

    @Test
    public void testInsertBatch() {
        List<ThirdPartyUser> thirdPartyUserDOs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ThirdPartyUser insertDO = new ThirdPartyUser();
            insertDO.setUid(IdentifierUtils.getNextAssignId());
            insertDO.setApplicationUid(IdentifierUtils.getNextAssignId());
            insertDO.setUserId(IdWorker.get32UUID());
            insertDO.setUserName("小明"+ i*10);
            insertDO.setAllowLogin(0);

            thirdPartyUserDOs.add(insertDO);
        }
        int i = thirdPartyUserMapper.insertBatch(thirdPartyUserDOs);
        log.debug("************ thirdPartyUserMapper.insertBatch number: {}", i);
    }

    @Test
    public void testInsertBatch2() {
        List<ThirdPartyUser> thirdPartyUserDOs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ThirdPartyUser insertDO = new ThirdPartyUser();
            insertDO.setUid(IdentifierUtils.getNextAssignId());
            insertDO.setApplicationUid(IdentifierUtils.getNextAssignId());
            insertDO.setUserId(IdWorker.get32UUID());
            insertDO.setUserName("小红"+ i*10);
            insertDO.setAllowLogin(0);

            thirdPartyUserDOs.add(insertDO);
        }

        int i = thirdPartyUserMapper.insertBatch2(thirdPartyUserDOs,"sys_u_third_party_user");
        log.debug("************ thirdPartyUserMapper2.insertBatch number: {}", i);
    }

    @Test
    public void testUpdateBatchIn() {
        List<ThirdPartyUser> thirdPartyUserPOs = thirdPartyUserMapper.selectAll();
//        String collect = thirdPartyUserPOs.stream().map(ThirdPartyUser::getUid).collect(Collectors.joining(","));
        List<String> collect = thirdPartyUserPOs.stream().map(ThirdPartyUser::getUid).collect(Collectors.toList());

        int i = thirdPartyUserMapper.testUpdateBatchByUids(collect,7);
        log.debug("************ testUpdateBatchByUids number: {}", i);
    }

}
