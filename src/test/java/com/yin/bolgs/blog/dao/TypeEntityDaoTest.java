package com.yin.bolgs.blog.dao;

import com.yin.bolgs.blog.pojo.TypeEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author 17694
 * @date 2021/03/08
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class TypeEntityDaoTest {
    @Autowired
    TypeEntityDao typeEntityDao;
    @Test
    public void findByName(){
        String name="dasda";
        TypeEntity byname = typeEntityDao.findByname(name);
        System.out.println(byname);
    }



}