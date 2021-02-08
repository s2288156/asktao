package com.asktao.ums.domain.role.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wcy
 */
@Data
public class Role {
    private String id;

    private LocalDateTime createTime;

    /**
     * 名称
     **/
    private String name;

    /**
     * 描述
     **/
    private String description;

    /**
     * 排序
     **/
    private Integer sort;
}
