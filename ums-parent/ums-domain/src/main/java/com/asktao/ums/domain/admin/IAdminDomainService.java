package com.asktao.ums.domain.admin;

import java.util.Set;

/**
 * @author wcy
 */
public interface IAdminDomainService {

    /**
     * 后台管理端用户注册
     *
     * @return
     */
    String register();

    Set<String> getRolesById(String uid);
}
