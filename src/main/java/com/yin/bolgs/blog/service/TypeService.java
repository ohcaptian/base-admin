package com.yin.bolgs.blog.service;

import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.common.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @author 17694
 * @date 2021/02/19
 **/
@Service
public interface TypeService extends CommonService<TypeEntity,TypeEntity,Long> {
    TypeEntity getTypeByName(String name);
}
