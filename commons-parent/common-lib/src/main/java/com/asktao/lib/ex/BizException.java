package com.asktao.lib.ex;

import lombok.Getter;

/**
 * @author wcy
 */
@Getter
public class BizException extends BaseException {
    private static final long serialVersionUID = -5496308092178328679L;

    private static final String DEFAULT_ERR_CODE = "BIZ_ERROR";

    public BizException(String message) {
        super(DEFAULT_ERR_CODE, message);
    }

    public BizException(ICode<String, String> errorEnum) {
        super(errorEnum);
    }

    public BizException(ICode<String, String> errorEnum, String msg) {
        super(errorEnum, msg);
    }

    public BizException(String code, String message) {
        super(code, message);
    }
}
