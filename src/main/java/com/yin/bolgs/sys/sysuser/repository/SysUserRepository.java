package com.yin.bolgs.sys.sysuser.repository;

import com.yin.bolgs.common.repository.CommonRepository;
import com.yin.bolgs.sys.sysuser.pojo.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends CommonRepository<SysUser, String> {
    SysUser findByLoginName(String username);
}
