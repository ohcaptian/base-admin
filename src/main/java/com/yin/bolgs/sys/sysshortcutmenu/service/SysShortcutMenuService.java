package com.yin.bolgs.sys.sysshortcutmenu.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonService;
import com.yin.bolgs.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.yin.bolgs.sys.sysshortcutmenu.vo.SysShortcutMenuVo;

import java.util.List;

public interface SysShortcutMenuService extends CommonService<SysShortcutMenuVo, SysShortcutMenu, String> {
    Result<List<SysShortcutMenuVo>> findByUserId(String userId);
}
