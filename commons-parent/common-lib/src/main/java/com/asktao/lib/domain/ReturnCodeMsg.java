package com.asktao.lib.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ReturnCodeMsg implements Serializable {
    private static final long serialVersionUID = 3136661064445721240L;

    private String code;

    private String message;

    public ReturnCodeMsg() {
    }

    public ReturnCodeMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
