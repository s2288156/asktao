package com.asktao.lib.ex;

import lombok.Getter;

/**
 * @author wcy
 */
public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 4911360448556404699L;

    @Getter
    private String errCode;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public BaseException(ICode<String, String> code) {
        this(code.code(), code.msg());
    }

    public BaseException(ICode<String, String> code, String message) {
        this(code.code(), message);
    }
}
