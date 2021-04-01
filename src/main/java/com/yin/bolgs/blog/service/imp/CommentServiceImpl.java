package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/03/26
 **/

import com.yin.bolgs.blog.pojo.CommentEntity;
import com.yin.bolgs.blog.service.CommentService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName : CommentServiceImpl 
 * @Description : 评论service层  
 */
@Service
public class CommentServiceImpl extends CommonServiceImpl<CommentEntity,CommentEntity,Long> implements CommentService {



}
