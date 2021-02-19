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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
              //model.addAttribute("types", typeService.getAllType());
              //model.addAttribute("tags", tagService.getAllTag());
       }
       @GetMapping("/blogs")  //后台显示博客列表
       @Override
       public Result<PageInfo<BlogVo>> page(BlogVo entityVo) {
              //TODO
              return super.page(entityVo);
       }
}
