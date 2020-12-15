package com.mall.lib.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author wcy
 */
@Slf4j
public class NetUtil {

    public static final String LOCALHOST = "127.0.0.1";

    private NetUtil() {
    }

    public static String localIp() {
        String hostAddress;
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("IdWorker init error:", e);
            hostAddress = LOCALHOST;
        }
        return StringUtils.isBlank(hostAddress) ? defaultRandomHost() : hostAddress;
    }

    private static String defaultRandomHost() {
        return "127.0.0." + RandomUtils.nextInt(0, 255);
    }
}
