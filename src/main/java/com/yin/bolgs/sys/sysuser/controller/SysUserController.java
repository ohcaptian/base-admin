package com.yin.bolgs.sys.sysuser.controller;

import com.yin.bolgs.annotation.Decrypt;
import com.yin.bolgs.annotation.Encrypt;
import com.yin.bolgs.common.controller.CommonController;
import com.yin.bolgs.common.pojo.PageInfo;
import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.sys.syssetting.service.SysSettingService;
import com.yin.bolgs.sys.sysuser.pojo.SysUser;
import com.yin.bolgs.sys.sysuser.service.SysUserService;
import com.yin.bolgs.sys.sysuser.vo.SysUserVo;
import com.yin.bolgs.util.SysSettingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sys/sysUser/")
public class SysUserController extends CommonController<SysUserVo, SysUser, String> {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private SysSettingService sysSettingService;

    @GetMapping("user")
    public ModelAndView user(){
        return new ModelAndView("sys/user/user","initPassword", SysSettingUtil.getSysSetting().getUserInitPassword());
    }

    /**
     * @deprecated 重置密码
     * @param sysUserVo
     * @return
     */
    @PostMapping("resetPassword")
//    @Decrypt
//    @Encrypt
    public Result<SysUserVo> resetPassword(SysUserVo sysUserVo){
        return sysUserService.resetPassword(sysUserVo.getUserId());
    }

    @PostMapping("pageOnLine")
    @Decrypt
    @Encrypt
    public Result<PageInfo<SysUserVo>> pageOnLine(SysUserVo sysUserVo){
        ArrayList<SysUserVo> sysUserVoList = new ArrayList<>();
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        for (Object allPrincipal : allPrincipals) {
            SysUserVo userVo = new SysUserVo();
            User user = (User) allPrincipal;
            userVo.setLoginName(user.getUsername());
            sysUserVoList.add(userVo);
        }
        PageInfo<SysUserVo> pageInfo = new PageInfo<>();
        pageInfo.setPage(1);//页码
        pageInfo.setPageSize(10000);//页面大小
        pageInfo.setRows(sysUserVoList);//分页结果
        pageInfo.setRecords(sysUserVoList.size());//总记录数
        pageInfo.setTotal(1);//总页数
        return Result.of(pageInfo);
    }

    @DeleteMapping("forced/{loginName}")
    public Result<String> forced( @PathVariable("loginName") String loginName) {
        //清除remember-me持久化tokens
        sysUserService.getPersistentTokenRepository2().removeUserTokens(loginName);

        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        for (Object allPrincipal : allPrincipals) {
            User user = (User) allPrincipal;
            if(user.getUsername().equals(loginName)){
                List<SessionInformation> allSessions = sessionRegistry.getAllSessions(user, true);
                if (allSessions != null) {
                    for (SessionInformation sessionInformation : allSessions) {
                        sessionInformation.expireNow();
                        sessionRegistry.removeSessionInformation(sessionInformation.getSessionId());
                    }
                }
                break;
            }
        }
        return Result.of("操作成功");
    }
}
