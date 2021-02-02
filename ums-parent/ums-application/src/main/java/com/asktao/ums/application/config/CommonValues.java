package com.asktao.ums.application.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author wcy
 */
@Data
@Component
@ConfigurationProperties(prefix = "ums.common-values")
@RefreshScope
public class CommonValues {

    private String defaultAvatar;
}
