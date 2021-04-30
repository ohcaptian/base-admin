package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.common.repository.CommonRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 17694
 * @date 2021/02/11
 **/

@Repository
public interface BlogEntityDao extends CommonRepository<BlogEntity, Long> {
    @Query("SELECT b FROM  BlogEntity b WHERE b.tagIds=?1")
    List<BlogEntity> getBlogByTagId(String id);
    @Query("SELECT b FROM  BlogEntity b WHERE b.typeId=?1")
    List<BlogEntity> getBlogByTypeId(Long id);

}
