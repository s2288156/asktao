package com.asktao.ums.application.cmd.role;

import com.asktao.lib.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author wcy
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleAssignCmd extends Command implements Serializable {
    private static final long serialVersionUID = 3547822275051436650L;

    private String uid;

    private List<String> roleIds;
}
