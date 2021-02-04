package com.asktao.ums.application.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AdminDetail extends AdminSim implements Serializable {
    private static final long serialVersionUID = 2713101227409307967L;

    private Integer age;

    private LocalDate birthday;

    private String icon;

    private String mobile;

    private String email;
}
