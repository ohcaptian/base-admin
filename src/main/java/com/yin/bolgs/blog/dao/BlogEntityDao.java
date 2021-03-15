package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 17694
 * @date 2021/02/11
 **/

@Repository
public interface BlogEntityDao extends CommonRepository<BlogEntity, Long> {

}
