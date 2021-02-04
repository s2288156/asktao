package com.asktao.ums.application.cmd.admin;

import com.asktao.lib.dto.Command;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.enums.AdminStatusEnum;
import com.asktao.ums.domain.gateway.enums.GenderEnum;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

/**
 * @author wcy
 */
@Data
public class AdminUpdateCmd extends Command {

    @NotBlank
    private String id;

    /**
     * 名字
     **/
    private String name;

    /**
     * 性别{@link GenderEnum}
     **/
    private String gender;

    /**
     * 账户状态{@link AdminStatusEnum}
     **/
    private String status;

    /**
     * 登录用户名
     **/
    private String username;

    public Admin convert2Admin() {
        Admin admin = new Admin();
        BeanUtils.copyProperties(this, admin);
        if (StringUtils.isNotBlank(getGender())) {
            admin.setGender(GenderEnum.valueOf(getGender()));
        }
        if (StringUtils.isNotBlank(getStatus())) {
            admin.setStatus(AdminStatusEnum.valueOf(getStatus()));
        }
        return admin;
    }
}
