package com.yin.bolgs.sys.sysmenu.controller;

import com.yin.bolgs.annotation.Decrypt;
import com.yin.bolgs.annotation.Encrypt;
import com.yin.bolgs.common.controller.CommonController;
import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.sys.sysmenu.pojo.SysMenu;
import com.yin.bolgs.sys.sysmenu.service.SysMenuService;
import com.yin.bolgs.sys.sysmenu.vo.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/sys/sysMenu/")
public class SysMenuController extends CommonController<SysMenuVo, SysMenu, String> {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping("menu")
    public ModelAndView menu(){
        return new ModelAndView("sys/menu/menu");
    }

    /**
     * 分层级
     */
    @PostMapping("listByTier")
    @Decrypt
    @Encrypt
    public Result<List<SysMenuVo>> listByTier(SysMenuVo entityVo) {
        return sysMenuService.listByTier(entityVo);
    }
}
