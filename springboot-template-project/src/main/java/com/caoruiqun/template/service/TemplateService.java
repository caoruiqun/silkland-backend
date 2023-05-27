package com.caoruiqun.template.service;

import com.caoruiqun.template.model.entity.UserInfo;
import com.caoruiqun.template.model.resquest.TemplateRequest;

import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:03
 * @desc:
 */
public interface TemplateService {
    List<UserInfo> templateFindAll();

    UserInfo templateCreate(TemplateRequest request);

    void templateEdit(TemplateRequest request);

    void templateRemove(Integer id);
}
