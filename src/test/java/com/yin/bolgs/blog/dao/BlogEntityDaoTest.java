package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.CommentEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author 17694
 * @date 2021/02/12
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class BlogEntityDaoTest {
    @Autowired
    private BlogEntityDao blogEntityDao;
    @Test
    public void findall(){
        log.info(String.valueOf(blogEntityDao.findAll()));
    }

    @Test
    public void findBlog(){
        BlogEntity blogEntity = blogEntityDao.findById(2L).get();
        String name =blogEntity .getType().getName();
        System.out.println(name);
    }

    /**
     * 根据博客id查找评论
     */
//    @Test
//    public void findCommentByBlogId(){
//        BlogEntity blogEntity = blogEntityDao.findById(1L).get();
//        List<CommentEntity> commentEntity = blogEntity.getCommentEntity();
//        commentEntity.stream().forEach(name->System.out.println(name));
//
//
//    }
    @Test
    public void findBlogByTagId(){
        List<BlogEntity> blogByTypeId = blogEntityDao.getBlogByTypeId(1l);
        blogByTypeId.stream().forEach(System.out::println);
    }


}