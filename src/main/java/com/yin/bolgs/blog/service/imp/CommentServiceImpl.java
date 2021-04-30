package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/03/26
 **/

import com.yin.bolgs.blog.dao.CommentEntityDao;
import com.yin.bolgs.blog.pojo.CommentEntity;
import com.yin.bolgs.blog.service.CommentService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * @ClassName : CommentServiceImpl 
 * @Description : 评论service层  
 */
@Service
public class CommentServiceImpl extends CommonServiceImpl<CommentEntity,CommentEntity,Long> implements CommentService {
    @Autowired
    private CommentEntityDao commentEntityDao;

    @Override
    public List<CommentEntity> selectComment(Long id) {
        return commentEntityDao.findAll().stream().filter(s -> s.getBlogId() == id).collect(toList());
    }
}
