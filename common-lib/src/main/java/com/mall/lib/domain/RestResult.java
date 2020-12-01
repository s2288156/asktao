package com.mall.lib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mall.lib.ex.IResultCode;
import com.mall.lib.ex.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestResult<T> extends ReturnCodeMsg implements Serializable {
    private static final long serialVersionUID = -6614763960648586816L;

    private final T data;

    public RestResult(String returnCode, String returnMsg, T data) {
        super(returnCode, returnMsg);
        this.data = data;
    }

    public static <T> RestResult<T> success() {
        return build(ResultCodeEnum.SUCCESS, null);
    }

    public static <T> RestResult<T> success(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> RestResult<T> failed(IResultCode<String, String> resultCode) {
        return build(resultCode, null);
    }

    public static <T> RestResult<T> failed(String returnCode, String returnMsg) {
        return new RestResult<>(returnCode, returnMsg, null);
    }

    public static <T> RestResult<T> unauthorized(T data) {
        return build(ResultCodeEnum.UNAUTHORIZED, data);
    }

    public static <T> RestResult<T> forbidden(T data) {
        return build(ResultCodeEnum.FORBIDDEN, data);
    }

    private static <T> RestResult<T> build(IResultCode<String, String> resultCode, T data) {
        return new RestResult<>(resultCode.code(), resultCode.msg(), data);
    }
}
