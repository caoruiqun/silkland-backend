package com.caoruiqun.knife4j.controller;

/**
 * @author caoruiqun
 * @date 2023/6/30 10:37
 * @desc:
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试 Knife4j")
@RestController
@RequestMapping("/knife4j")
public class Knife4jController {

    @ApiOperation("测试方法")
    @RequestMapping(value ="/test", method = RequestMethod.POST)
    public String test() {
        return "沉默王二又帅又丑";
    }
}
