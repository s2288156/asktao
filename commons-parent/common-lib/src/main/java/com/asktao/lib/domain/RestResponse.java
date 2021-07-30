package com.asktao.lib.domain;

import com.asktao.lib.ex.CodeEnum;
import com.asktao.lib.ex.ICode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

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

    public boolean ok() {
        return StringUtils.equals(CodeEnum.SUCCESS.code(), getCode());
    }

    public boolean bad() {
        return !ok();
    }

    public static <T> RestResponse<T> success() {
        return build(CodeEnum.SUCCESS, null);
    }

    public static <T> RestResponse<T> success(T data) {
        return build(CodeEnum.SUCCESS, data);
    }

    public static <T> RestResponse<T> failed(ICode<String, String> resultCode) {
        return build(resultCode, null);
    }

    public static <T> RestResponse<T> failed(String returnMsg) {
        return new RestResponse<>(CodeEnum.SYS_EXECUTE_ERROR.code(), returnMsg, null);
    }

    public static <T> RestResponse<T> failed(String returnCode, String returnMsg) {
        return new RestResponse<>(returnCode, returnMsg, null);
    }

    public static <T> RestResponse<T> unauthorized(T data) {
        return build(CodeEnum.UNAUTHORIZED, data);
    }

    public static <T> RestResponse<T> forbidden(T data) {
        return build(CodeEnum.FORBIDDEN, data);
    }

    private static <T> RestResponse<T> build(ICode<String, String> resultCode, T data) {
        return new RestResponse<>(resultCode.code(), resultCode.msg(), data);
    }
}
