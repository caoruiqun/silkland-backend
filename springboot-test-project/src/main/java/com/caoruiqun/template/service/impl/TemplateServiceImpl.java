package com.caoruiqun.template.service.impl;

import com.caoruiqun.template.mapper.TemplateMapper;
import com.caoruiqun.template.model.entity.UserInfo;
import com.caoruiqun.template.model.resquest.TemplateRequest;
import com.caoruiqun.template.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:04
 * @desc:
 */
@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public List<UserInfo> templateFindAll() {
        List<UserInfo> userInfoList = templateMapper.selectAll();
        return userInfoList;
    }

    @Override
    @Transactional
    public UserInfo templateCreate(TemplateRequest request) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(request.getName());
        userInfo.setAge(request.getAge());
        userInfo.setCreateTime(new Date());
        int insertCount = templateMapper.insertUserInfo(userInfo);
        if (insertCount <= 0) {
            throw new RuntimeException("插入数据失败！");
        }
        return userInfo;
    }

    @Override
    @Transactional
    public void templateEdit(TemplateRequest request) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(request.getId());
        userInfo.setName(request.getName());
        int updateCount = templateMapper.updateUserInfoById(userInfo);
        if (updateCount <= 0) {
            throw new RuntimeException("更新数据失败！");
        }
    }

    @Override
    @Transactional
    public void templateRemove(Integer id) {
        int deleteCount = templateMapper.deleteUserInfoById(id);
        if (deleteCount <= 0) {
            throw new RuntimeException("删除数据失败！");
        }
    }
}
