package com.asktao.lib.secure;

/**
 * @author wcy
 */
public enum Mode {
    /**
     * 加密算法模式
     */
    NONE,
    CBC,
    CFB,
    CTR,
    CTS,
    ECB,
    OFB,
    PCBC;

    private Mode() {
    }
}