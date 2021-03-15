package com.yin.bolgs.sys.sysusermenu.repository;

import com.yin.bolgs.common.repository.CommonRepository;
import com.yin.bolgs.sys.sysusermenu.pojo.SysUserMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMenuRepository extends CommonRepository<SysUserMenu, String> {
    List<SysUserMenu> findByUserId(String userId);
}
