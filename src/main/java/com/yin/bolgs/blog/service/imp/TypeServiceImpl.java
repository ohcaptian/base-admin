package com.yin.bolgs.blog.service.imp;/**
 * @author 17694
 * @date 2021/02/19
 **/


import com.yin.bolgs.blog.dao.TypeEntityDao;
import com.yin.bolgs.blog.pojo.TypeEntity;
import com.yin.bolgs.blog.service.TypeService;
import com.yin.bolgs.common.service.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : TypeServiceImpl 
 * @Description :   
 */
@Service
public class TypeServiceImpl extends CommonServiceImpl<TypeEntity, TypeEntity,Long> implements TypeService {
    @Autowired
    private TypeEntityDao typeEntityDao;

    @Override
    public TypeEntity getTypeByName(String name) {
        return typeEntityDao.findByname(name);
    }
}
