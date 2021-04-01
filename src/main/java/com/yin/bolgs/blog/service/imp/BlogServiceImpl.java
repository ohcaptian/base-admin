package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/02/12
 **/

import com.yin.bolgs.blog.dao.BlogEntityDao;
import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName : BlogServiceImpl 
 * @Description :   
 */
@Service
public class BlogServiceImpl extends CommonServiceImpl<BlogEntity, BlogEntity,Long> implements BlogService {
    @Autowired
    private BlogEntityDao blogEntityDao;

    @Override
    public List<BlogEntity> searchAllBlog(BlogEntity blogEntity) {
        //todo 根据Id,名称等进行查询
        //List<BlogEntity> allBlog = blogEntityDao.findAll();
        return null;
    }
}
