package cn.huanzi.qch.baseadmin.blog.controller;

import cn.huanzi.qch.baseadmin.blog.pojo.TypeEntity;
import cn.huanzi.qch.baseadmin.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admin/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("types")
    public String types(@RequestParam(required = false,defaultValue = "0",value = "pagenum")int pageNum, Model model){
//        PageHelper.startPage(pagenum, 5);
//        List<Type> allType = typeService.getAllType();
//        //得到分页结果对象
//        PageInfo<Type> pageInfo = new PageInfo<>(allType);
//        model.addAttribute("pageInfo", pageInfo);
        Pageable pageable = PageRequest.of(pageNum,4);
        Page<TypeEntity> TypeList = typeService.findAll(pageable);
        model.addAttribute("list", TypeList);
        return "blog/admin/types";
    }

    @GetMapping("/types/input")
    public String toAddType(Model model){
        model.addAttribute("type", new TypeEntity());   //返回一个type对象给前端th:object
        return "blog/admin/types-input";
    }

    @GetMapping("/types/{id}/input")
    public String toEditType(@PathVariable Long id, Model model){
        model.addAttribute("type", typeService.get(id));
        return "blog/admin/types-input";
    }

    @PostMapping("/types")
    public String addType(TypeEntity type, RedirectAttributes attributes){   //新增
        TypeEntity t = typeService.getTypeByName(type.getName());
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
        }
        typeService.save(type);
        return "redirect:/admin/types";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @PostMapping("/types/{id}")
    public String editType(@PathVariable Long id, TypeEntity type, RedirectAttributes attributes){  //修改
        TypeEntity t = typeService.getTypeByName(type.getName());
        if(t != null){
            attributes.addFlashAttribute("msg", "不能添加重复的分类");
            return "redirect:/admin/types/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        typeService.save(type);
        return "redirect:/admin/types";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        typeService.delete(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/types";
    }
}
