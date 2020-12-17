package com.asktao.lib.secure.asymmetric;

import com.asktao.lib.secure.SecureUtil;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

/**
 * @author wcy
 */
public class Sign extends BaseAsymmetric {

    protected Signature signature;

    public Sign(SignAlgorithm algorithm, String publicKey, String privateKey) {
        this(algorithm, SecureUtil.generatePublicKey(algorithm, publicKey), SecureUtil.generatePrivateKey(algorithm, privateKey));
    }

    @SneakyThrows
    public Sign(SignAlgorithm algorithm, PublicKey publicKey, PrivateKey privateKey) {
        super(algorithm.getValue(), publicKey, privateKey);
        this.signature = Signature.getInstance(algorithm.getValue());
    }

    @SneakyThrows
    public String sign(String data) {
        signature.initSign(privateKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signature.sign());
    }

    @SneakyThrows
    public boolean verify(String data, String sign) {
        signature.initVerify(publicKey);
        signature.update(data.getBytes(StandardCharsets.UTF_8));
        return signature.verify(Base64.getDecoder().decode(sign));
    }
}
