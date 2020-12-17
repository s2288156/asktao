package com.asktao.lib.secure.asymmetric;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wcy
 */
public enum SignAlgorithm {
    /**
     * 签名算法
     */
    NONEwithRSA("NONEwithRSA"),
    MD2withRSA("MD2withRSA"),
    MD5withRSA("MD5withRSA"),
    SHA1withRSA("SHA1withRSA"),
    SHA256withRSA("SHA256withRSA"),
    SHA384withRSA("SHA384withRSA"),
    SHA512withRSA("SHA512withRSA"),
    NONEwithDSA("NONEwithDSA"),
    SHA1withDSA("SHA1withDSA"),
    NONEwithECDSA("NONEwithECDSA"),
    SHA1withECDSA("SHA1withECDSA"),
    SHA256withECDSA("SHA256withECDSA"),
    SHA384withECDSA("SHA384withECDSA"),
    SHA512withECDSA("SHA512withECDSA");

    private String value;

    private SignAlgorithm(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public String getAfterWith() {
        return StringUtils.split(this.value, "with")[1];
    }
}