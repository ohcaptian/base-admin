package com.yin.bolgs.sys.syssetting.repository;


import com.yin.bolgs.common.repository.CommonRepository;
import com.yin.bolgs.sys.syssetting.pojo.SysSetting;
import org.springframework.stereotype.Repository;

@Repository
public interface SysSettingRepository extends CommonRepository<SysSetting, String> {
}
