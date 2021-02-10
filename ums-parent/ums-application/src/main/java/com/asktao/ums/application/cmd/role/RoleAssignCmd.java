package com.asktao.ums.application.cmd.role;

import com.asktao.lib.dto.Command;
import com.asktao.ums.domain.admin.entity.Admin;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Set;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleAssignCmd extends Command implements Serializable {
    private static final long serialVersionUID = 3547822275051436650L;

    private String uid;

    private Set<String> roleIds;

    public Admin convert2Admin() {
        Admin admin = new Admin();
        admin.setId(this.uid);
        admin.setRoleIds(this.roleIds);
        return admin;
    }
}
