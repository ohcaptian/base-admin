package cn.huanzi.qch.baseadmin.common.service;


import cn.huanzi.qch.baseadmin.common.pojo.PageInfo;
import cn.huanzi.qch.baseadmin.common.pojo.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 通用Service
 *
 * @param <V> 实体类Vo
 * @param <E> 实体类
 */
public interface CommonService<V, E,T> {

    Result<PageInfo<V>> page(V entityVo);

    Result<List<V>> list(V entityVo);

    Result<V> get(T id);

    Result<V> save(V entityVo);

    Result<T> delete(T id);

     Page<E> findAll(Pageable pageable);
     List<E> findAll();
     void saveNew(E entityEntity);

}
