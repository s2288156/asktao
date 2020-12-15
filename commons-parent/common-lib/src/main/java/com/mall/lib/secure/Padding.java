package com.mall.lib.secure;

import lombok.Getter;

/**
 * @author wcy
 */
public enum Padding {
    /**
     * 算法补码方式
     */
    NONE("NoPadding"),
    ISO10126("ISO10126Padding"),
    OAEP("OAEPPadding"),
    PKCS1("PKCS1Padding"),
    PKCS5("PKCS5Padding"),
    SSL3("SSL3Padding");

    private Padding(String value) {
        this.value = value;
    }

    @Getter
    private String value;
}