package com.yin.bolgs.sys.sysmenu.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.sys.sysmenu.pojo.SysMenu;
import com.yin.bolgs.sys.sysmenu.vo.SysMenuVo;
import com.yin.bolgs.common.service.CommonService;

import java.util.List;

public interface SysMenuService extends CommonService<SysMenuVo, SysMenu, String> {
    Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo);
}
