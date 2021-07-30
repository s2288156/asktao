package com.asktao.lib.dto;

import com.asktao.lib.ex.ICode;

/**
 * @author wuyang
 */
public class Response extends DTO{
    private static final long serialVersionUID = 4234838229805132634L;
    private boolean success;
    private String errCode;
    private String errMessage;

    public Response() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return this.errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String toString() {
        return "Response [success=" + this.success + ", errCode=" + this.errCode + ", errMessage=" + this.errMessage + "]";
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess(true);
        return response;
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static Response buildFailure(ICode<String, String> errorCode) {
        Response response = new Response();
        response.setSuccess(false);
        response.setErrCode(errorCode.code());
        response.setErrMessage(errorCode.msg());
        return response;
    }

}
