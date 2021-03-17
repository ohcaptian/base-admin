package com.yin.bolgs.blog.controller;


import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.TagEntity;
import com.yin.bolgs.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("tags")
    public String tags(@RequestParam(required = false,defaultValue = "0",value = "pageNum")int pageNum, Model model){
        Pageable pageable = PageRequest.of(pageNum,4);
        Page<TagEntity> tagList = tagService.findAll(pageable);
        model.addAttribute("list", tagList);
        return "blog/admin/tags";
    }

    @GetMapping("tags/input")
    public String toAddTag(Model model){
        model.addAttribute("tag", new TagEntity());   //返回一个tag对象给前端th:object
        return "blog/admin/tags-input";
    }

    @GetMapping("tags/{id}/input")
    public String toEditTag(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.get(id).getData());
        return "blog/admin/tags-input";
    }

    @PostMapping("tags")
    public String addTag(TagEntity tag, RedirectAttributes attributes){   //新增
        List<TagEntity> t = tagService.getTagByName(tag.getName());
        if(t.isEmpty()){
            tagService.saveNew(tag);
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/admin/tags";   //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
        } else {
            attributes.addFlashAttribute("msg", "不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }


    }

    @PostMapping("tags/{id}")
    public String editTag(@PathVariable Long id, TagEntity tag, RedirectAttributes attributes){  //修改
        List<TagEntity> t = tagService.getTagByName(tag.getName());
        if(t.isEmpty()){
            tagService.saveNew(tag);
            attributes.addFlashAttribute("msg", "添加成功");
            return "redirect:/admin/tags";   //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
        }else {
            attributes.addFlashAttribute("msg", "不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }
    }

    @GetMapping("tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.delete(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/tags";
    }
}
