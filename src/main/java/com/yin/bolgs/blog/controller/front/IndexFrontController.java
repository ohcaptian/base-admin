package com.yin.bolgs.blog.controller.front;

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.CommentService;
import com.yin.bolgs.blog.service.TagService;
import com.yin.bolgs.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/front/")
public class IndexFrontController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("index")
    public String toIndex(@RequestParam(required = false,defaultValue = "0",value = "pageNum")int pageNum, Model model){
        Pageable pageable = PageRequest.of(pageNum,5);
//        List<BlogEntity> allBlog = blogService.getIndexBlog();
//        List<TypeEntity> allType = typeService.getBlogType();  //获取博客的类型(联表查询)
//        List<TagEntity> allTag = tagService.getBlogTag();  //获取博客的标签(联表查询)
//        List<BlogEntity> recommendBlog =blogService.getAllRecommendBlog();  //获取推荐博客
        Page<BlogEntity> allBlog = blogService.findAll(pageable);
        Page<TypeEntity> allType = typeService.findAll(pageable);
        Page<TagEntity> allTag = tagService.findAll(pageable);


        //得到分页结果对象
        //PageInfo pageInfo = new PageInfo(allBlog);
        //model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("blogs", allBlog);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs", allBlog);
        return "blog/front/index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "0",value = "pageNum")int pageNum,
                         @RequestParam String query, Model model){

        Pageable pageable = PageRequest.of(pageNum,4);
        //todo 方法未实现
        //List<BlogEntity> searchBlog = blogService.getSearchBlog(query);
       Page<BlogEntity> searchBlog = blogService.findAll(pageable);
        //PageInfo pageInfo = new PageInfo(searchBlog);
        model.addAttribute("pageInfo", searchBlog);
        model.addAttribute("query", query);
        return "blog/front/search";
    }

    @GetMapping("/blog/{id}")
    public String toLogin(@PathVariable Long id, Model model){
        //Blog blog = blogService.getDetailedBlog(id);
        model.addAttribute("comments",commentService.selectComment(id));
        BlogEntity blog=blogService.getAndConvert(id);
        //System.out.println(blog.getContent());
        model.addAttribute("blog", blog);
        return "blog/front/blog";
    }
}
