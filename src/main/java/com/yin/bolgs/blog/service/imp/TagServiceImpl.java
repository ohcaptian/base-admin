package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/02/19
 **/

import com.yin.bolgs.blog.dao.TagEntityDao;
import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.blog.service.TagService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : TagServiceImpl 
 * @Description :   
 */
@Service
public class TagServiceImpl extends CommonServiceImpl<TagEntity, TagEntity,Long> implements TagService {
    @Autowired
    private TagEntityDao tagEntityDao;

    @Override
    public List<TagEntity> getTagByName(String name) {
        //todo
        //List<TagEntity> byname = tagEntityDao.findByName(name);
        return tagEntityDao.findByName(name);
    }

//    @Override
//    public TagEntity getTagByName(String name) {
//        return tagEntityDao.findByname(name);
//    }
}
