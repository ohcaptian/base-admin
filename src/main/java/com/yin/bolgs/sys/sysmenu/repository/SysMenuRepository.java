package com.yin.bolgs.sys.sysmenu.repository;


import com.yin.bolgs.sys.sysmenu.pojo.SysMenu;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMenuRepository extends CommonRepository<SysMenu, String> {
}
