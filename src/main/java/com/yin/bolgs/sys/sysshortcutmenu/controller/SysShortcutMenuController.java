package com.yin.bolgs.sys.sysshortcutmenu.controller;

import com.yin.bolgs.common.controller.CommonController;
import com.yin.bolgs.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.yin.bolgs.sys.sysshortcutmenu.service.SysShortcutMenuService;
import com.yin.bolgs.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/sysShortcutMenu/")
public class SysShortcutMenuController extends CommonController<SysShortcutMenuVo, SysShortcutMenu, String> {
    @Autowired
    private SysShortcutMenuService sysShortcutMenuService;
}
