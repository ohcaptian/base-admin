package com.yin.bolgs.user.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.sys.sysuser.vo.SysUserVo;

public interface UserService {
    Result<SysUserVo> updatePassword(String oldPassword, String newPassword);

    Result<SysUserVo> updateUser(SysUserVo sysUserVo);
}
