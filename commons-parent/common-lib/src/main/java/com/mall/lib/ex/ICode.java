package com.mall.lib.ex;

/**
 * @author wcy
 */
public interface ICode<C, M> {

    /**
     * 获取枚举code
     *
     * @return code
     */
    C code();

    /**
     * 获取枚举msg
     *
     * @return msg
     */
    M msg();
}
