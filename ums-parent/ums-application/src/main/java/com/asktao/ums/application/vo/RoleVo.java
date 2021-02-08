package com.asktao.ums.application.vo;

import com.asktao.lib.dto.DTO;
import com.asktao.ums.domain.role.entity.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleVo extends DTO implements Serializable {
    private static final long serialVersionUID = 1779114977217915760L;

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

    public static RoleVo createForDomain(Role role) {
        RoleVo roleVo = new RoleVo();
        BeanUtils.copyProperties(role, roleVo);
        return roleVo;
    }
}
