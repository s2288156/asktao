package com.mall.lib.ex;

import lombok.Getter;

/**
 * @author wcy
 */
@Getter
public class SysException extends BaseException {
    private static final long serialVersionUID = -5496308092178328679L;

    public SysException(ICode<String, String> errorEnum) {
        super(errorEnum);
    }

    public SysException(ICode<String, String> errorEnum, String msg) {
        super(errorEnum, msg);
    }
}
