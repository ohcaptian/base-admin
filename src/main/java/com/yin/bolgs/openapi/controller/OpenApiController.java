package com.yin.bolgs.openapi.controller;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.openapi.service.OpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/openApi/")
public class OpenApiController {

    @Autowired
    private OpenApiService openApiService;

    @GetMapping("test")
    public Result<String> test() {
        return openApiService.test();
    }
    @GetMapping("test/hello")
    public String hello(){
        return "hello";
    }
}
