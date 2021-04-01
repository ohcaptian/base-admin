package com.yin.bolgs.blog.service;

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
public class TypeServiceTest {
        @Autowired
    private TypeService typeService;
        @Test
        public void save(){
            TypeEntity typeEntity = new TypeEntity();
            typeEntity.setName("dsdsddd");
            //typeEntity.setId(100L);
            typeService.saveNew(typeEntity);
        }

}