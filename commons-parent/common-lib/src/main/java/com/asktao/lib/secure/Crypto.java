package com.asktao.lib.secure;

/**
 * @author wcy
 */
public interface Crypto {

    /**
     * 加密
     *
     * @param content 加密内容
     * @return 加密结果
     */
    byte[] encrypt(String content);

    /**
     * 加密
     *
     * @param content 加密内容
     * @return 加密结果
     */
    String encryptBase64(String content);

    /**
     * 解密
     *
     * @param encryptContent 密文
     * @return 解密结果
     */
    byte[] decrypt(byte[] encryptContent);

    /**
     * 解密
     *
     * @param encryptContent 密文
     * @return 解密结果
     */
    String decryptStr(byte[] encryptContent);

    /**
     * 解密
     *
     * @param encryptContent 密文
     * @return 解密结果
     */
    String decryptStr(String encryptContent);
}
