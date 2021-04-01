package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.TagEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @author 17694
 * @date 2021/02/22
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class TagEntityDaoTest {
    @Autowired
    private TagEntityDao tagEntityDao;
    @Test
    public void findByname() {
        String name="前端";
        List<TagEntity> blog = tagEntityDao.findByName("前端");
        blog.stream().forEach(System.out::println);

    }
}