package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author 17694
 * @date 2021/02/12
 **/
@Repository
public interface TagEntityDao extends CommonRepository<TagEntity,Long> {
           List<TagEntity> findByname(String name);
}
