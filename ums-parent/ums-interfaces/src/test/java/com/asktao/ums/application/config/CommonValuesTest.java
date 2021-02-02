package com.asktao.ums.application.config;

import com.asktao.ums.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wcy
 */
@Slf4j
public class CommonValuesTest extends BaseTest {

    @Autowired
    private CommonValues commonValues;

    @Test
    void getValuesTest() {
        Assertions.assertNotNull(commonValues.getDefaultAvatar());
        log.warn(">>>>>>>>>>>>>>>>>> {}", commonValues.getDefaultAvatar());
    }
}
