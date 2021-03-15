package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.CommentEntity;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 17694
 * @date 2021/02/12
 **/
@Repository
public interface CommentEntityDao extends CommonRepository<CommentEntity,Long> {
}
