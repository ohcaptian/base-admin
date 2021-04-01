package com.yin.bolgs.blog.service;

import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.common.service.CommonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 17694
 * @date 2021/02/19
 **/
@Service
public interface TagService extends CommonService<TagEntity, TagEntity,Long> {
            List<TagEntity> getTagByName(String name);
            //TagEntity getTagByName(String name);
}
