package com.caoruiqun.template.web;

import com.caoruiqun.template.common.result.ResponseResult;
import com.caoruiqun.template.common.result.ResponseResultBuilder;
import com.caoruiqun.template.model.entity.UserInfo;
import com.caoruiqun.template.model.resquest.TemplateRequest;
import com.caoruiqun.template.service.TemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:01
 * @desc:
 */
@Slf4j
@RestController
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @GetMapping("/templateFindAll")
    public ResponseResult templateFindAll() {
        List<UserInfo> userInfoList = templateService.templateFindAll();
        if (CollectionUtils.isEmpty(userInfoList)) {
            return ResponseResultBuilder.buildResult("未查询到数据！");
        }
        return ResponseResultBuilder.buildSuccessResult(userInfoList);
    }

    @PostMapping("/templateCreate")
    public ResponseResult templateCreate(@RequestBody TemplateRequest request) {
        UserInfo userInfo = templateService.templateCreate(request);
        if (ObjectUtils.isEmpty(userInfo.getId())) {
            return ResponseResultBuilder.buildResult("获取插入数据主键失败！");
        }
        return ResponseResultBuilder.buildSuccessResult(userInfo);
    }

    @PutMapping("/templateEdit")
    public ResponseResult templateEdit(@RequestBody TemplateRequest request) {
        templateService.templateEdit(request);
        return ResponseResultBuilder.buildSuccessResult();
    }

    @DeleteMapping("/templateRemove/{id}")
    public ResponseResult templateRemove(@PathVariable Integer id) {
        templateService.templateRemove(id);
        return ResponseResultBuilder.buildSuccessResult();
    }
}
