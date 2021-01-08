package com.asktao.ums.domain.gateway;

import com.asktao.ums.domain.admin.entity.Admin;

/**
 * @author wcy
 */
public interface AdminGateway {

    String insert(Admin admin);

    boolean existForUsername(Admin admin);
}
