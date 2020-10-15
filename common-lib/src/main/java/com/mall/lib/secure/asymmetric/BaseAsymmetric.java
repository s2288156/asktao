package com.mall.lib.secure.asymmetric;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author wcy
 */
public class BaseAsymmetric {

    protected String algorithm;

    protected PublicKey publicKey;

    protected PrivateKey privateKey;

    public BaseAsymmetric(String algorithm, PublicKey publicKey, PrivateKey privateKey) {
        this.algorithm = algorithm;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }
}
