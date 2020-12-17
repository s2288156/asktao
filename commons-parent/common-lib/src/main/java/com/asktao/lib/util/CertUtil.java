package com.asktao.lib.util;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/**
 * @author wcy
 */
public class CertUtil {

    private KeyStore keyStore;

    private String password;

    @SneakyThrows
    public void initKeyStore(String filePath, String type, String password) {
        this.keyStore = KeyStore.getInstance(type);
        this.password = password;
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(filePath);
        keyStore.load(is, password.toCharArray());
    }

    @SneakyThrows
    public PublicKey getPubKey() {
        Enumeration<String> aliasenum = keyStore.aliases();
        String keyAlias;
        if (aliasenum.hasMoreElements()) {
            keyAlias = aliasenum.nextElement();
            if (keyStore.isKeyEntry(keyAlias)) {
                X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(keyAlias);
                return x509Certificate.getPublicKey();
            }
        }
        throw new IllegalStateException("获取公钥失败");
    }

    @SneakyThrows
    public PrivateKey getPriKey() {
        Enumeration<String> aliasenum = keyStore.aliases();
        if (aliasenum.hasMoreElements()) {
            String keyAlias = aliasenum.nextElement();
            if (keyStore.isKeyEntry(keyAlias)) {
                return (PrivateKey) keyStore.getKey(keyAlias, password.toCharArray());
            }
        }
        throw new IllegalStateException("获取私钥失败");
    }
}
