package cn.huanzi.qch.baseadmin.blog.controller;


import cn.huanzi.qch.baseadmin.blog.pojo.TagEntity;
import cn.huanzi.qch.baseadmin.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String tags(@RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum, Model model){
//        PageHelper.startPage(pagenum, 5);
//        List<Tag> allTag = tagService.getAllTag();
//        //得到分页结果对象
//        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
//        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String toAddTag(Model model){
        model.addAttribute("tag", new TagEntity());   //返回一个tag对象给前端th:object
        return "admin/tags-input";
    }

    @GetMapping("/tags/{id}/input")
    public String toEditTag(@PathVariable Long id, Model model){
        model.addAttribute("tag", tagService.get(id));
        return "admin/tags-input";
    }

    @PostMapping("/tags")
    public String addTag(TagEntity tag, RedirectAttributes attributes){   //新增
        TagEntity t = tagService.getTagByName(tag.getName());
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
        }
        tagService.save(tag);
        return "redirect:/admin/tags";   //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
    }

    @PostMapping("/tags/{id}")
    public String editTag(@PathVariable Long id, TagEntity tag, RedirectAttributes attributes){  //修改
        TagEntity t = tagService.getTagByName(tag.getName());
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的标签");
            return "redirect:/admin/tags/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        tagService.save(tag);
        return "redirect:/admin/tags";   //不能直接跳转到tags页面，否则不会显示tag数据(没经过tags方法)
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        tagService.delete(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/tags";
    }
}
