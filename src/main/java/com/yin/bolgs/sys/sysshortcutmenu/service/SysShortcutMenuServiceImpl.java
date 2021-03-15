package com.yin.bolgs.sys.sysshortcutmenu.service;

import com.yin.bolgs.common.pojo.Result;
import com.yin.bolgs.common.service.CommonServiceImpl;
import com.yin.bolgs.sys.sysshortcutmenu.pojo.SysShortcutMenu;
import com.yin.bolgs.sys.sysshortcutmenu.repository.SysShortcutMenuRepository;
import com.yin.bolgs.sys.sysshortcutmenu.vo.SysShortcutMenuVo;
import com.yin.bolgs.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class SysShortcutMenuServiceImpl extends CommonServiceImpl<SysShortcutMenuVo, SysShortcutMenu, String> implements SysShortcutMenuService{

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SysShortcutMenuRepository sysShortcutMenuRepository;

    @Override
    public Result<String> delete(String id) {
        //先删除子节点
        SysShortcutMenuVo sysShortcutMenuVo = new SysShortcutMenuVo();
        sysShortcutMenuVo.setShortcutMenuParentId(id);
        super.list(sysShortcutMenuVo).getData().forEach((menuVo)->{
            super.delete(menuVo.getShortcutMenuId());
        });
        //再删除自己
        return super.delete(id);
    }

    @Override
    public Result<List<SysShortcutMenuVo>> findByUserId(String userId) {
        List<SysShortcutMenuVo> shortcutMenuVoList = new ArrayList<>();
        List<SysShortcutMenuVo> sysShortcutMenuVoList = CopyUtil.copyList(sysShortcutMenuRepository.findByUserId(userId), SysShortcutMenuVo.class);
        sysShortcutMenuVoList.forEach((SysShortcutMenuVo) -> {
            if(StringUtils.isEmpty(SysShortcutMenuVo.getShortcutMenuParentId())){
                //上级节点
                shortcutMenuVoList.add(SysShortcutMenuVo);
            }
        });
        sysShortcutMenuVoList.forEach((SysShortcutMenuVo) -> {
            if(!StringUtils.isEmpty(SysShortcutMenuVo.getShortcutMenuParentId())){
                //子节点
                shortcutMenuVoList.forEach((sysShortcutMenuVoP) -> {
                    if(sysShortcutMenuVoP.getShortcutMenuId().equals(SysShortcutMenuVo.getShortcutMenuParentId())){
                        sysShortcutMenuVoP.getChildren().add(SysShortcutMenuVo);
                    }
                });
            }
        });

        //排序
        shortcutMenuVoList.sort(order());
        shortcutMenuVoList.forEach((sysMenuVoP) -> {
            sysMenuVoP.getChildren().sort(order());
        });

        return Result.of(shortcutMenuVoList);
    }
    /**
     * 排序,根据sortWeight排序
     */
    private Comparator<SysShortcutMenuVo> order(){
        return (o1, o2) -> {
            if (!o1.getSortWeight().equals(o2.getSortWeight())){
                return o1.getSortWeight() - o2.getSortWeight();
            }
            return 0 ;
        };
    }

}
