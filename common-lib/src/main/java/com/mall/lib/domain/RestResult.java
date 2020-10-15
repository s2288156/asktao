package com.mall.lib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mall.lib.ex.IResultCode;
import com.mall.lib.ex.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = -6614763960648586816L;

    private final String returnCode;

    private final String returnMsg;

    private final T data;

    public RestResult(String returnCode, String returnMsg, T data) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }

    public static <T> RestResult<T> success() {
        return build(ResultCodeEnum.SUCCESS, null);
    }

    public static <T> RestResult<T> success(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> RestResult<T> error(IResultCode<String, String> resultCode) {
        return build(resultCode, null);
    }

    public static <T> RestResult<T> error(String returnCode, String returnMsg) {
        return new RestResult<>(returnCode, returnMsg, null);
    }

    private static <T> RestResult<T> build(IResultCode<String, String> resultCode, T data) {
        return new RestResult<>(resultCode.code(), resultCode.msg(), data);
    }
}
