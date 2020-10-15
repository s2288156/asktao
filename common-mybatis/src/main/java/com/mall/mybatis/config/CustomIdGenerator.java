package com.mall.mybatis.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.mall.lib.util.IdWorker;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
        return IdWorker.getId();
    }
}