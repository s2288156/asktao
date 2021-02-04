package com.asktao.ums.application.cmd.admin;

import com.asktao.lib.dto.Command;
import com.asktao.ums.domain.admin.entity.Admin;
import com.asktao.ums.domain.gateway.enums.AdminStatusEnum;
import com.asktao.ums.domain.gateway.enums.GenderEnum;
import lombok.Data;
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
    @NotBlank
    private String gender;

    /**
     * 账户状态{@link AdminStatusEnum}
     **/
    @NotBlank
    private String status;

    /**
     * 登录用户名
     **/
    @NotBlank
    private String username;

    public Admin convert2Admin() {
        Admin admin = new Admin();
        BeanUtils.copyProperties(this, admin);
        admin.setGender(GenderEnum.valueOf(getGender()));
        admin.setStatus(AdminStatusEnum.valueOf(getStatus()));
        return admin;
    }
}
