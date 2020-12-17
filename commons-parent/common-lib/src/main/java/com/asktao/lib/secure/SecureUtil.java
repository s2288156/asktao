package com.asktao.lib.secure;

import com.asktao.lib.secure.asymmetric.SignAlgorithm;
import lombok.SneakyThrows;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author wcy
 */
public class SecureUtil {
    private SecureUtil() {
    }

    @SneakyThrows
    public static PrivateKey generatePrivateKey(SignAlgorithm algorithm, String privateKey) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm.getAfterWith());
        return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    }

    @SneakyThrows
    public static PublicKey generatePublicKey(SignAlgorithm algorithm, String publicKey) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm.getAfterWith());
        return keyFactory.generatePublic(x509EncodedKeySpec);
    }
}
