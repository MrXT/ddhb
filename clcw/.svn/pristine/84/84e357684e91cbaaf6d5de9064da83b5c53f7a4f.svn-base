package com.manzz.framework.core.mybatis.session;

import org.apache.ibatis.session.RowBounds;

import com.manzz.framework.core.common.Constants;

/**
 * Mybatis分页对象扩展
 * @author WJK
 * @version 2014-09
 */
public class MybatisRowBounds extends RowBounds{
    
    private int offset;//偏移量
    private int limit; //限制量(记录数)
    
    /** 获取偏移量*/
    public int getOffset()
    {
        return offset;
    }

    /** 获取限制量(记录数)*/
    public int getLimit()
    {
        return limit;
    }
    
    /**
     * 构造函数
     * @param pageIndex 当前页索引
     * @param pageSize  当前页记录数
     */
    public MybatisRowBounds(int pageIndex, int pageSize)
    {
        this.limit = pageSize > 0 ? pageSize : Constants.DEFAULT_PAGE_SIZE;
        this.offset = pageIndex > 1 ? (pageIndex - 1) * pageSize : 0;
    }
}