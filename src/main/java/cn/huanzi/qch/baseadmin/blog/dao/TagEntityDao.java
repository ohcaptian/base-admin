package cn.huanzi.qch.baseadmin.blog.dao;

import cn.huanzi.qch.baseadmin.blog.pojo.TagEntity;
import cn.huanzi.qch.baseadmin.common.repository.CommonRepository;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * @author 17694
 * @date 2021/02/12
 **/
@Repository
public interface TagEntityDao extends CommonRepository<TagEntity,Long> {
           List<TagEntity> findByname(String name);
}
