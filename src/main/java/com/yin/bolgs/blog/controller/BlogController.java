package com.yin.bolgs.blog.controller;
/**
 * @author 17694
 * @date 2021/02/12
 **/

import com.yin.bolgs.blog.pojo.BlogEntity;
import com.yin.bolgs.blog.service.BlogService;
import com.yin.bolgs.blog.service.TagService;
import com.yin.bolgs.blog.service.TypeService;
import com.yin.bolgs.common.controller.CommonController;
import com.yin.bolgs.common.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @ClassName : BlogController 
 * @Description :   
 */
@Controller
@RequestMapping("/admin/")
@Slf4j
public class BlogController extends CommonController<BlogEntity,BlogEntity,Long> {
       @Autowired
       private BlogService blogService;
       @Autowired
       private TypeService typeService;
       @Autowired
       private TagService tagService;
       public void setTypeAndTag(Model model) {
              //TODO
              model.addAttribute("types", typeService.findAll());
              model.addAttribute("tags", tagService.findAll());
       }
       @GetMapping("blogs")  //后台显示博客列表
       public String page(@RequestParam(required = false,defaultValue = "0",value = "pageNum")int pageNum,Model model){
           Pageable pageable = PageRequest.of(pageNum,4);
           Page<BlogEntity> blogList = blogService.findAll(pageable);
           model.addAttribute("list", blogList);
           setTypeAndTag(model);  //查询类型和标签
           return "blog/admin/blogs";
       }
    @PostMapping("blogs/search")  //按条件查询博客
    public String searchBlogs(BlogEntity blog, @RequestParam(required = false,defaultValue = "1",value = "pagenum")int pageNum, Model model){
        Pageable pageable = PageRequest.of(pageNum,4);
        List<BlogEntity> allBlog = blogService.searchAllBlog(blog);
        //得到分页结果对象
        model.addAttribute("pageInfo", allBlog);
        model.addAttribute("message", "查询成功");
        setTypeAndTag(model);
        return "blog/admin/blogs";
    }
    @GetMapping("blogs/input") //去新增博客页面
    public String toAddBlog(Model model){
        model.addAttribute("blog", new BlogEntity());  //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "blog/admin/blogs-input";
    }
    @GetMapping("blogs/{id}/input") //去编辑博客页面
    public String toEditBlog(@PathVariable Long id, Model model){
        Result<BlogEntity> blogVoResult = blogService.get(id);
        BlogEntity blog = blogVoResult.getData();
        blog.init();   //将tags集合转换为tagIds字符串
        model.addAttribute("blog", blog);     //返回一个blog对象给前端th:object
        setTypeAndTag(model);
        return "blog/admin/blogs-input";
    }

    @PostMapping("blogs") //新增、编辑博客
    public String addBlog(BlogEntity blog,RedirectAttributes attributes){

           if(blog.getAppreciation()==null){
               blog.setAppreciation("0");
           }
        if(blog.getCommentabled()==null){
            blog.setCommentabled("0");
        }
        if(blog.getShareStatement()==null){
            blog.setShareStatement("0");
        }
        if(blog.getRecommend()==null){
            blog.setRecommend("0");
        }
        blog.setTypeId(blog.getType().getId());
        //给blog中的List<Tag>赋值
        blog.setTags(tagService.getTagByName(blog.getTagIds()));
        if (blog.getId() == null) {   //id为空，则为新增
            blogService.saveNew(blog);
        } else {
            blogService.saveNew(blog);
        }

        attributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/admin/blogs";
    }

    @GetMapping("blogs/{id}/delete")
    public String deleteBlogs(@PathVariable Long id, RedirectAttributes attributes){
        attributes.addFlashAttribute("msg", blogService.delete(id).getMsg());
        return "redirect:/admin/blogs";
    }
}
