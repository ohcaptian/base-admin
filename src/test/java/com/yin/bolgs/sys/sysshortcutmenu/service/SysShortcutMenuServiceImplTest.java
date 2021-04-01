package com.yin.bolgs.sys.sysshortcutmenu.service;

import com.yin.bolgs.sys.sysmenu.service.SysMenuService;
import com.yin.bolgs.sys.sysmenu.vo.SysMenuVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 17694
 * @date 2021/02/13
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class SysShortcutMenuServiceImplTest {
    @Autowired
    private SysMenuService sysMenuService;
    @Test
        public void test(){
        SysMenuVo entityVo = new SysMenuVo();
        sysMenuService.listByTier(entityVo);
        }
}