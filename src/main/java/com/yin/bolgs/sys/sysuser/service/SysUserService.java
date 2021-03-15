package com.yin.bolgs.sys.sysuser.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonService;
import com.yin.bolgs.sys.sysuser.pojo.SysUser;
import com.yin.bolgs.sys.sysuser.vo.SysUserVo;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public interface SysUserService extends CommonService<SysUserVo, SysUser, String> {
    Result<SysUserVo> findByLoginName(String username);
    Result<SysUserVo> resetPassword(String userId);
    PersistentTokenRepository getPersistentTokenRepository2();
}
