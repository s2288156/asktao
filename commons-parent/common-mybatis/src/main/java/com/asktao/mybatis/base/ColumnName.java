package com.asktao.mybatis.base;

import java.util.Arrays;
import java.util.List;

/**
 * @author wcy
 */
public class ColumnName {
    private ColumnName() {
    }

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    public static void main(String[] args) {
        List<Integer> asList = Arrays.asList(1, 2, 3);
        System.out.println(asList.get(0));
        System.out.println(asList.get(1));
        System.out.println(asList.get(2));
        asList.add(4);
    }
}
