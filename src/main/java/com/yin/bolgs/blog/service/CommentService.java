package com.yin.bolgs.blog.service;


import com.yin.bolgs.blog.pojo.CommentEntity;
import com.yin.bolgs.blog.vo.CommentVo;
import com.yin.bolgs.common.service.CommonService;
import org.springframework.stereotype.Service;

/**
 * @author 17694
 * @date 2021/02/19
 **/
@Service
public interface CommentService extends CommonService<CommentEntity, CommentEntity,Long> {

}
