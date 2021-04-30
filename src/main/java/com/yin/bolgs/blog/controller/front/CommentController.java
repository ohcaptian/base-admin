package com.yin.bolgs.blog.controller.front;


import com.yin.bolgs.blog.pojo.CommentEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/front/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

//    @Value("${comment.avatar}")
    private static String avatar ="/blogs/images/avatar.jpg";

    @GetMapping("/comments/{blogId}")  //展示留言
    public String comments(@PathVariable Long blogId, Model model){
        //获取评论
        model.addAttribute("comments",commentService.selectComment(blogId));
        //获取blog详情
        model.addAttribute("blog", blogService.get(blogId).getData());
        return "blog/front/blog :: commentList";
    }

    @PostMapping("/comments")   //提交留言
    public String post(CommentEntity comment, HttpSession session){
        Long blogId = comment.getBlog().getId();
        //绑定博客与评论
        comment.setBlog(blogService.get(blogId).getData());
        //不设置id无法自增
        comment.setId(111l);
        comment.setBlogId(blogId);
        comment.setAvatar(avatar);
        System.out.println(comment);
        commentService.save(comment);
        return "redirect:/comments/" + blogId;
    }
}
