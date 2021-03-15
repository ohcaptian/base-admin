package com.yin.bolgs.sys.sysuserauthority.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonService;
import com.yin.bolgs.sys.sysuserauthority.pojo.SysUserAuthority;
import com.yin.bolgs.sys.sysuserauthority.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, SysUserAuthority, String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
