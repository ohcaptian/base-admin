package com.yin.bolgs.blog.controller.front;


import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.TypeService;
import com.yin.bolgs.common.pojo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    //@GetMapping("/types/{id}")
//    public String types(@PathVariable Long id, @RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,
//                        Model model){
//
//        List<TypeEntity> types = typeService.getBlogType();
//        //-1从导航点过来的
//        if (id == -1){
//            id = types.get(0).getId();
//        }
//        List<BlogEntity> blogs = blogService.getByTypeId(id);
//        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
//        model.addAttribute("types", types);
//        model.addAttribute("pageInfo", pageInfo);
//        model.addAttribute("activeTypeId", id);
//
//        return "types";
//    }
}
