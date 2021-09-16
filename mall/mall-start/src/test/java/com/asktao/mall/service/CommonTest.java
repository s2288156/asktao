package com.asktao.mall.service;

import com.asktao.mall.NoneWebBaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wuyang
 */
@Slf4j
public class CommonTest extends NoneWebBaseTest {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testPasswordEncoder() {
        log.info("{}", passwordEncoder.encode("123123"));
    }
}
