package com.asktao.lib.ex;

import lombok.Getter;

/**
 * @author wcy
 */
@Getter
public class SysException extends BaseException {
    private static final long serialVersionUID = -5496308092178328679L;

    private static final String DEFAULT_ERR_CODE = "SYS_ERROR";

    public SysException(String message) {
        super(DEFAULT_ERR_CODE, message);
    }

    public SysException(ICode<String, String> errorEnum) {
        super(errorEnum);
    }

    public SysException(ICode<String, String> errorEnum, String msg) {
        super(errorEnum, msg);
    }
}
