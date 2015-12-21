package com.manzz.framework.core.model;

import java.util.List;

import com.manzz.framework.core.mybatis.session.MybatisRowBounds;

/**
 * ClassName: BasePaginationService <br/>
 * Function: 带分页的DAO实现类. <br/>
 *
 * @author WJK
 * @version 2014-10-08 
 */
public interface PaginationDAO<T> extends BaseDAO<T> {
    /**
     * 功能:根据条件查询记录
     * @param condition 查询条件
     * @param rowBounds 分页条件
     */
    List<T> queryPagedList(T condition, MybatisRowBounds rowBounds);

    /** 功能:根据条件查询记录数 */
    int queryCount(T condition);
}
