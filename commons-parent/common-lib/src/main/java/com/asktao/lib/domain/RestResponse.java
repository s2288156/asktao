package com.asktao.lib.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.asktao.lib.ex.ICode;
import com.asktao.lib.ex.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestResponse<T> extends ReturnCodeMsg implements Serializable {
    private static final long serialVersionUID = -6614763960648586816L;

    private final T data;

    public RestResponse(String returnCode, String returnMsg, T data) {
        super(returnCode, returnMsg);
        this.data = data;
    }

    public static <T> RestResponse<T> success() {
        return build(ResultCodeEnum.SUCCESS, null);
    }

    public static <T> RestResponse<T> success(T data) {
        return build(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> RestResponse<T> failed(ICode<String, String> resultCode) {
        return build(resultCode, null);
    }

    public static <T> RestResponse<T> failed(String returnCode, String returnMsg) {
        return new RestResponse<>(returnCode, returnMsg, null);
    }

    public static <T> RestResponse<T> unauthorized(T data) {
        return build(ResultCodeEnum.UNAUTHORIZED, data);
    }

    public static <T> RestResponse<T> forbidden(T data) {
        return build(ResultCodeEnum.FORBIDDEN, data);
    }

    private static <T> RestResponse<T> build(ICode<String, String> resultCode, T data) {
        return new RestResponse<>(resultCode.code(), resultCode.msg(), data);
    }
}
