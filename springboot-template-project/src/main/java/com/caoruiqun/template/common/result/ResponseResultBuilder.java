package com.caoruiqun.template.common.result;

import com.caoruiqun.template.common.enums.ResultCodeEnum;

/**
 * @author caoruiqun
 * @date 2023/5/26 15:41
 * @desc:
 */
public class ResponseResultBuilder {

    public static ResponseResult buildResult() {
        return new ResponseResult();
    }

    public static ResponseResult buildResult(String message) {
        return new ResponseResult(0, message);
    }
    public static ResponseResult buildResult(Integer code, String message) {
        return new ResponseResult(code, message);
    }

    public static ResponseResult buildSuccessResult() {
        return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getName());
    }

    public static ResponseResult buildSuccessResult(Object data) {
        return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getName(), data);
    }

    public static ResponseResult buildSuccessResult(String message, Object data) {
        return new ResponseResult(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    public static ResponseResult buildErrorResult(ResultCodeEnum resultCodeEnum) {
        return new ResponseResult(resultCodeEnum.getCode(), resultCodeEnum.getName());
    }

    public static ResponseResult buildErrorResult(ResultCodeEnum resultCodeEnum, Object data) {
        return new ResponseResult(resultCodeEnum.getCode(), resultCodeEnum.getName(), data);
    }

    public static ResponseResult buildErrorResult(String message) {
        return new ResponseResult(-1, message);
    }

    public static ResponseResult buildErrorResult(Integer code, String message) {
        return new ResponseResult(code, message);
    }

    public static ResponseResult buildErrorResult(Integer code, String message, Object data) {
        return new ResponseResult(code, message, data);
    }

    public static ResponseResult buildErrorResult(ResultCodeEnum resultCodeEnum, Object... placeholders) {
        return new ResponseResult(resultCodeEnum.getCode(), resultCodeEnum.getName(), placeholders);
    }

    public static PageResponseResult buildSuccessResult(PageResponseResult responseResult) {
        responseResult.setCode(ResultCodeEnum.SUCCESS.getCode());
        responseResult.setMessage(ResultCodeEnum.SUCCESS.getName());
        return responseResult;
    }

    public static PageResponseResult buildErrorPageResult(String message) {
        PageResponseResult responseResult = new PageResponseResult();
        responseResult.setCode(-1);
        responseResult.setMessage(message);
        return responseResult;
    }

}
