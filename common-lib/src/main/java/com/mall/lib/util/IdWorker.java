package com.mall.lib.util;


/**
 * @author wcy
 */
public class IdWorker {
    private static long workerId;

    static {
        String hostAddress = NetUtil.localIp();
        workerId = Long.parseLong(hostAddress.split("\\.")[3]);
    }

    private static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(workerId, 0);

    public static long getId() {
        return idWorker.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(getId());
    }
}
