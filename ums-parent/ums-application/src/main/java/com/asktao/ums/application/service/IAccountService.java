package com.asktao.ums.application.service;

import com.asktao.ums.application.dto.LoginCmd;
import com.asktao.ums.application.dto.MemberRegisterCmd;
import com.asktao.ums.domain.member.entity.Member;
import com.asktao.ums.application.dto.AdminAccountRegisterCmd;
import com.asktao.ums.dto.AdminInfoCO;
import org.springframework.http.ResponseEntity;

/**
 * 账户相关
 *
 * @author wcy
 */
public interface IAccountService {

    /**
     * 注册会员
     *
     * @param memberRegister 账号和密码
     */
    void registerMember(MemberRegisterCmd memberRegister);

    /**
     * 查询会员详细信息
     *
     * @param uid 用户id
     * @return 用户信息
     */
    Member detailForUid(String uid);

    /**
     * 门户会员、后台管理员登录
     *
     * @param loginCmd 登录信息
     * @return token信息
     */
    ResponseEntity<?> login(LoginCmd loginCmd);

    /**
     * 后台管理员注册
     *
     * @param accountRegisterCmd 注册信息
     */
    void registerAdmin(AdminAccountRegisterCmd accountRegisterCmd);

    AdminInfoCO getAdminRoles(String uid);
}
