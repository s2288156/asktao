package com.asktao.lib.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.money.Money;

import java.math.RoundingMode;

/**
 * @author wuyang
 */
public class RmbMoneyUtil {
    private static final String CNY = "CNY ";

    public static Money parseMoney(String amount) {
        if (StringUtils.isBlank(amount)) {
            return Money.parse(CNY + "0");
        }
        return Money.parse(CNY + amount);
    }

    public static Money parseMoney(Integer amount) {
        return Money.parse(CNY + amount);
    }

    public static Money zero() {
        return parseMoney("0");
    }

    /**
     * 字符 分转元
     */
    public static Money convertFenToYuan(String amount) {
        Money parseMoney = parseMoney(amount);
        return parseMoney.dividedBy(100, RoundingMode.HALF_UP);
    }
}
