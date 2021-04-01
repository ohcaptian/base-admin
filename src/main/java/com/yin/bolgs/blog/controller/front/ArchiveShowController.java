package com.yin.bolgs.blog.controller.front;


import com.yin.bolgs.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/")
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        //博客归档 todo
        //model.addAttribute("archiveMap", blogService.archiveBlog());
        //博客数量
        model.addAttribute("blogCount", blogService.findAll().size());
        return "blog/front/archives";
    }
}
