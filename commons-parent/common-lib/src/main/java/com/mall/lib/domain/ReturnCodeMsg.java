package com.mall.lib.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
public class ReturnCodeMsg implements Serializable {
    private static final long serialVersionUID = 3136661064445721240L;

    private String returnCode;

    private String returnMsg;

    public ReturnCodeMsg() {
    }

    public ReturnCodeMsg(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }
}
