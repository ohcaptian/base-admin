package com.yin.bolgs.blog.service.imp;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.common.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 17694
 * @date 2021/02/13
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class BlogServiceImplTest {
    @Autowired
    private BlogService blogService;
    @Test
    public void test(){
        log.info(blogService.get(1L).toString());
    }
    @Test
    public void delete(){
        Result<Long> delete = blogService.delete(5l);
        System.out.println(delete.getMsg());
    }
    @Test
    public void save(){
        BlogEntity blogEntity = new BlogEntity();

        for (int i=0;i<10;i++){
            blogEntity.setAppreciation("1"+i);
            blogEntity.setShareStatement("1"+i);
            blogEntity.setCommentabled("1"+i);
            blogEntity.setPublished("11"+i);
            blogEntity.setRecommend("222"+i);
            blogService.saveNew(blogEntity);
        }
    }


}