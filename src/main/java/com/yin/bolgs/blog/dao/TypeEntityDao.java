package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;


/**
 * @author 17694
 * @date 2021/02/12
 **/
@Repository
public interface TypeEntityDao extends CommonRepository<TypeEntity,Long> {
            TypeEntity findByname(String name);
}
