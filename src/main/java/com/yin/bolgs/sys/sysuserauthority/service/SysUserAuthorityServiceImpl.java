package com.yin.bolgs.sys.sysuserauthority.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonServiceImpl;
import com.yin.bolgs.sys.sysuserauthority.pojo.SysUserAuthority;
import com.yin.bolgs.sys.sysuserauthority.repository.SysUserAuthorityRepository;
import com.yin.bolgs.sys.sysuserauthority.vo.SysUserAuthorityVo;
import com.yin.bolgs.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class SysUserAuthorityServiceImpl extends CommonServiceImpl<SysUserAuthorityVo, SysUserAuthority, String> implements SysUserAuthorityService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysUserAuthorityRepository sysUserAuthorityRepository;

    @Override
    public Result<List<SysUserAuthorityVo>> findByUserId(String userId) {
        return Result.of(CopyUtil.copyList(sysUserAuthorityRepository.findByUserId(userId),SysUserAuthorityVo.class));
    }

    @Override
    public Result<Boolean> saveAllByUserId(String userId, String authorityIdList) {
        //先删除旧的
        SysUserAuthorityVo sysUserAuthorityVo = new SysUserAuthorityVo();
        sysUserAuthorityVo.setUserId(userId);
        list(sysUserAuthorityVo).getData().forEach((userAuthorityVo)->{
            delete(userAuthorityVo.getUserAuthorityId());
        });

        //再保存新的
        for (String authorityId : authorityIdList.split(",")) {
            sysUserAuthorityVo.setAuthorityId(authorityId);
            save(sysUserAuthorityVo);
        }
        return Result.of(true);
    }
}
