package com.yin.bolgs.sys.sysuserauthority.repository;

import com.yin.bolgs.common.repository.CommonRepository;
import com.yin.bolgs.sys.sysuserauthority.pojo.SysUserAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserAuthorityRepository extends CommonRepository<SysUserAuthority, String> {
    List<SysUserAuthority> findByUserId(String userId);
}
