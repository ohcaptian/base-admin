package com.yin.bolgs.blog.service;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.common.service.CommonService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 17694
 * @date 2021/02/12
 **/
@Service
public interface BlogService extends CommonService<BlogEntity, BlogEntity,Long> {
                List<BlogEntity> searchAllBlog(BlogEntity blogEntity);
                //BlogEntity getDetailedBlog(Long id);
                //前端展示
                BlogEntity getAndConvert(Long id);
                //根据Tagid查找博客
                List<BlogEntity> getByTypeId(Long id);
                 //根据Typeid查找博客
                List<BlogEntity> getByTagId(String id);

}
