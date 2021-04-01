package com.yin.bolgs.blog.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/front/")
public class AboutShowController {

    @GetMapping("/about")
    public String about(){
        return "blog/front/about";
    }
}
