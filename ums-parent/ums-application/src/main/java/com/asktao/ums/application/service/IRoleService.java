package com.asktao.ums.application.service;

import com.asktao.ums.application.vo.RoleVo;

import java.util.List;

/**
 * @author wcy
 */
public interface IRoleService {

    List<RoleVo> allForUid(String uid);

}
