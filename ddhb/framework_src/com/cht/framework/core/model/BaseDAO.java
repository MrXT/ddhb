package com.cht.framework.core.model;

import java.util.List;

/**
 * ClassName: BasePaginationService <br/>
 * Function: DAO实现类基类. <br/>
 *
 * @author WJK
 * @version 2015-01
 */
public interface BaseDAO<T> {
    int deleteByPrimaryKey(String id);

    int insert(T record);

    T selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
    
    List<T> queryPagedList(T condition);
}
