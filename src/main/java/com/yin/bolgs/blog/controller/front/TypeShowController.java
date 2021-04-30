package com.yin.bolgs.blog.controller.front;


import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.TypeService;
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
@RequestMapping("/front/")
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("types/{id}")
    public String types(@PathVariable Long id, @RequestParam(required = false,defaultValue = "0",value = "pageNum")int pageNum,
                        Model model){
        Pageable pageable = PageRequest.of(pageNum,5);
        Page<TypeEntity> types = typeService.findAll(pageable);
        List<TypeEntity> type = typeService.findAll();

        //-1从导航点过来的
        if (id == -1){
           id= types.get().findFirst().get().getId();
             //= types.get(0).getId();
        }
        List<BlogEntity> pageInfo = blogService.getByTypeId(id);
        //Page<BlogEntity> pageInfo=blogService.findAll(pageable);
        model.addAttribute("types", types);
        model.addAttribute("typeLength",type);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);

        return "blog/front/types";
    }
}
