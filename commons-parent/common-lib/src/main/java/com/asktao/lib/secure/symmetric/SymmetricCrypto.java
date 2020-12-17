package com.asktao.lib.secure.symmetric;


import com.asktao.lib.secure.Crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 对称加密
 *
 * @author wcy
 */
public class SymmetricCrypto implements Crypto {

    private Cipher cipher;

    private SecretKey secretKey;

    private AlgorithmParameterSpec parameterSpec;

    private final Lock lock = new ReentrantLock();

    public SymmetricCrypto(String algorithm, SecretKey secretKey, AlgorithmParameterSpec parameterSpec) {
        this(algorithm, secretKey);
        this.parameterSpec = parameterSpec;
    }

    public SymmetricCrypto(String algorithm, SecretKey secretKey) {
        try {
            this.cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw new IllegalStateException("cipher.getInstance error:", e);
        }
        this.secretKey = secretKey;
    }

    @Override
    public byte[] encrypt(String content) {
        lock.lock();
        try {
            if (this.parameterSpec == null) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, parameterSpec);
            }
            return cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String encryptBase64(String content) {
        return Base64.getEncoder().encodeToString(encrypt(content));
    }

    @Override
    public byte[] decrypt(byte[] encryptContent) {
        lock.lock();
        try {
            if (this.parameterSpec == null) {
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey, parameterSpec);
            }
            return cipher.doFinal(encryptContent);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String decryptStr(byte[] encryptContent) {
        return new String(decrypt(encryptContent), StandardCharsets.UTF_8);
    }

    @Override
    public String decryptStr(String encryptContent) {
        return decryptStr(Base64.getDecoder().decode(encryptContent));
    }
}
