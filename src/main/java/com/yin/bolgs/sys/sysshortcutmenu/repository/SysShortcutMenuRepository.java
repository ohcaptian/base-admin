package com.yin.bolgs.sys.sysshortcutmenu.repository;

import com.yin.bolgs.common.repository.CommonRepository;
import com.yin.bolgs.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysShortcutMenuRepository extends CommonRepository<SysShortcutMenu, String> {
    List<SysShortcutMenu> findByUserId(String userId);
}
