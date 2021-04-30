package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/02/12
 **/

import com.yin.bolgs.blog.dao.BlogEntityDao;
import com.yin.bolgs.blog.exception.NotFoundException;
import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import com.yin.bolgs.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

    @Override
    public BlogEntity getAndConvert(Long id) {
        BlogEntity blogEntity = blogEntityDao.findById(id).orElse(null);
        if(blogEntity==null){
            throw  new NotFoundException("博客不存在");
        }
        BlogEntity b = new BlogEntity();
        BeanUtils.copyProperties(blogEntity,b);
        //格式转化
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return b;
    }

    @Override
    public List<BlogEntity> getByTypeId(Long id) {
        return blogEntityDao.getBlogByTypeId(id);
    }

    @Override
    public List<BlogEntity> getByTagId(String id) {
        return blogEntityDao.getBlogByTagId(id);
    }

    /**
     * 根据TagId查找
     * @return
     */

//    @Override
//    public BlogEntity getDetailedBlog(Long id) {
//        BlogEntity blog = blogEntityDao.getDetailedBlog(id);
//        if (blog == null) {
//            throw new NotFoundException("该博客不存在");
//        }
//        String content = blog.getContent();
//        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));  //将Markdown格式转换成html
//        return blog;
//    }
}
