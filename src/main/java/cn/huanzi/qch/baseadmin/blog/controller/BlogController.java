package cn.huanzi.qch.baseadmin.blog.controller;
/**
 * @author 17694
 * @date 2021/02/12
 **/

import cn.huanzi.qch.baseadmin.blog.pojo.BlogEntity;
import cn.huanzi.qch.baseadmin.blog.pojo.UserEntity;
import cn.huanzi.qch.baseadmin.blog.service.BlogService;
import cn.huanzi.qch.baseadmin.blog.service.TagService;
import cn.huanzi.qch.baseadmin.blog.service.TypeService;
import cn.huanzi.qch.baseadmin.blog.vo.BlogVo;
import cn.huanzi.qch.baseadmin.common.controller.CommonController;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName : BlogController 
 * @Description :   
 */
@Controller
@RequestMapping("/admin/")
@Slf4j
public class BlogController extends CommonController<BlogEntity,BlogEntity,Long>{
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
        //设置user属性
        //blog.setUser((UserEntity) session.getAttribute("user"));
        //设置用户id
        //blog.setUserId(blog.getUser().getId());
        //设置blog的type
        //typeService.get(blog.getType().getId());
        blog.setType(typeService.get(blog.getType().getId()).getData());
        //设置blog中typeId属性
        blog.setTypeId(blog.getType().getId());
        //给blog中的List<Tag>赋值
        blog.setTags(tagService.getTagByString(blog.getTagIds()));
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
