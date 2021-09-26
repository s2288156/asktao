package com.asktao.auth.clientimpl;

import com.asktao.auth.client.IAuthClient;
import com.asktao.lib.dto.SingleResponse;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;

/**
 * @author wuyang
 */
@Slf4j
@RestController
public class AuthClientImpl implements IAuthClient {

    @Autowired
    private KeyPair keyPair;

    @SneakyThrows
    @Override
    public SingleResponse<?> publicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return SingleResponse.of(new JWKSet(key).getKeys().get(0).getRequiredParams().get("n"));
    }
}
