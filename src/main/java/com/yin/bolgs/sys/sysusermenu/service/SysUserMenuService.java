package com.yin.bolgs.sys.sysusermenu.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonService;
import com.yin.bolgs.sys.sysmenu.vo.SysMenuVo;
import com.yin.bolgs.sys.sysusermenu.pojo.SysUserMenu;
import com.yin.bolgs.sys.sysusermenu.vo.SysUserMenuVo;

import java.util.List;

public interface SysUserMenuService extends CommonService<SysUserMenuVo, SysUserMenu, String> {
    Result<List<SysMenuVo>> findByUserId(String userId);

    Result<Boolean> saveAllByUserId(String userId, String menuIdList);
}
