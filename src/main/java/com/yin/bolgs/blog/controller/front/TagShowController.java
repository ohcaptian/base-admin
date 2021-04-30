package com.yin.bolgs.blog.controller.front;


import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.TagService;
import com.yin.bolgs.common.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/front")
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String types(@PathVariable Long id, @RequestParam(required = false,defaultValue = "1",value = "pagenum")int pageNum,
                        Model model){
        Pageable pageable = PageRequest.of(pageNum,5);
        //PageHelper.startPage(pagenum, 100);  //开启分页
        List<TagEntity> tags = tagService.findAll();
        //-1从导航点过来的
        if (id == -1){
            id = tags.get(0).getId();
        }
        List<BlogEntity> pageInfo = blogService.getByTagId(String.valueOf(id));
        //PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        //Page<BlogEntity> pageInfo=blogService.findAll(pageable);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTagId", id);
        return "blog/front/tags";
    }
}
