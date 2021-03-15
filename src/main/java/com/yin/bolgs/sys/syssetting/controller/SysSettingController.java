package com.yin.bolgs.sys.syssetting.controller;

import com.yin.bolgs.common.controller.CommonController;
import com.yin.bolgs.sys.syssetting.pojo.SysSetting;
import com.yin.bolgs.sys.syssetting.service.SysSettingService;
import com.yin.bolgs.sys.syssetting.vo.SysSettingVo;
import com.yin.bolgs.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/sys/sysSetting/")
public class SysSettingController extends CommonController<SysSettingVo, SysSetting, String> {
    @Autowired
    private SysSettingService sysSettingService;

    @GetMapping("setting")
    public ModelAndView setting() {
        return new ModelAndView("sys/setting/setting", "sys", SysSettingUtil.getSysSetting());
    }
}
