package cn.huanzi.qch.baseadmin.blog.dao;

import cn.huanzi.qch.baseadmin.blog.pojo.BlogTagsEntity;
import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 17694
 * @date 2021/02/12
 **/
@Repository
public interface BlogTagsEntityDao extends CommonRepository<BlogTagsEntity,Long> {
}