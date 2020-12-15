package com.mall.lib.ex;

/**
 * @author wcy
 */
public enum ResultCodeEnum implements ICode<String, String> {
    /**
     * 错误码列表，共5位：错误产生来源 + 四位数字编号，四位数字从0001~9999，大类之间步长100<br>
     * 错误产生来源(A/B/C)：
     * <p>- A表示来源于用户，比如参数错误；</p>
     * <p>- B表示来源于当前系统，比如业务逻辑错误、代码健壮性不足；</p>
     * <p>- C表示错误来源于第三方，比如CDN服务出错，超时等</p>
     */
    SUCCESS("00000", "成功"),
    // 一级宏观错误码
    USER_ERROR("A0001", "用户端错误"),
    USER_REGISTER_ERROR("A0100", "用户注册错误"),
    UNAUTHORIZED("A0101", "暂未登录或token已经过期"),
    FORBIDDEN("A0102", "没有相关权限"),
    USERNAME_EXISTS("A0111", "用户名已存在"),
    USERNAME_NOT_EXISTS("A0112", "用户名不存在"),
    USER_NOT_EXISTS("A0113", "用户不存在"),
    USER_LOGIN_ERROR("A0200", "用户登录异常"),
    PERMISSION_ERROR("A0300", "权限访问异常"),
    USER_PARAMS_ERROR("A0400", "用户请求参数错误"),
    ROLE_EXIST("A0401", "角色已经存在"),
    INVALID_INPUT("A0402", "无效的用户输入"),
    ORDER_CLOSED("A0443", "订单已关闭"),
    // 一级宏观错误码
    SYS_EXECUTE_ERROR("B0001", "系统执行出错"),
    // 二级宏观错误码
    SYS_EXECUTE_TIMEOUT("B0100", "系统执行超时");

    private String code;

    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}
