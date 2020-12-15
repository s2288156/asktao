package com.mall.lib.ex;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author wcy
 */
@Getter
public class BizException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -5496308092178328679L;

    private final String code;

    public BizException(IResultCode<String, String> errorEnum) {
        super(errorEnum.msg());
        this.code = errorEnum.code();
    }

    public BizException(IResultCode<String, String> errorEnum, String msg) {
        super(msg);
        this.code = errorEnum.code();
    }

    public BizException(String message, String code) {
        super(message);
        this.code = code;
    }
}
