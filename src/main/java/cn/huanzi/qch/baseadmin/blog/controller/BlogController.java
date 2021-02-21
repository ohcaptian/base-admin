package cn.huanzi.qch.baseadmin.blog.controller;
/**
 * @author 17694
 * @date 2021/02/12
 **/

import cn.huanzi.qch.baseadmin.blog.pojo.BlogEntity;
import cn.huanzi.qch.baseadmin.blog.service.BlogService;
import cn.huanzi.qch.baseadmin.blog.service.TagService;
import cn.huanzi.qch.baseadmin.blog.service.TypeService;
import cn.huanzi.qch.baseadmin.blog.vo.BlogVo;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName : BlogController 
 * @Description :   
 */
@Controller
@RequestMapping("/admin")
public class BlogController extends CommonController<BlogVo,BlogEntity,Long>{
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
       @GetMapping("/blogs")  //后台显示博客列表
       public String page(@RequestParam(required = false,defaultValue = "1",value = "page")int page,Model model){
              //TODO
           Pageable pageable = PageRequest.of(page,4);
           Page<BlogEntity> blogList = blogService.findAll(pageable);
           model.addAttribute("list", blogList);
           setTypeAndTag(model);  //查询类型和标签
           return "blog/admin/blogs";
       }
    @PostMapping("/blogs/search")  //按条件查询博客
    public String searchBlogs(BlogEntity blog, @RequestParam(required = false,defaultValue = "1",value = "pagenum")int page, Model model){
        Pageable pageable = PageRequest.of(page,4);
        List<BlogEntity> allBlog = blogService.searchAllBlog(blog);
        //得到分页结果对象
        model.addAttribute("pageInfo", allBlog);
        model.addAttribute("message", "查询成功");
        setTypeAndTag(model);
        return "blog/admin/blogs";
    }
}
