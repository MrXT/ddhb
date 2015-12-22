/**
 * Project Name:dtdp
 * File Name:BaseService.java
 * Package Name:com.cht.framework.core.model
 * Date:2014-09-30下午4:21:05
 * Copyright (c) 2014, cht.com All Rights Reserved.
 *
 */

package com.cht.framework.core.service;

import com.cht.framework.core.model.PaginationVO;

/**
 * ClassName: BasePaginationService <br/>
 * Function: 带分页功能的Service. <br/>
 *
 * @author WJK
 * @version 2014-09-30 
 */
public interface PaginationService<T> extends BaseService<T>{
    /**
     * 功能:查询指定条件的分页记录信息
     * @param condition 包含所有查询条件
     * @param pageIndex 指定当前查询页的索引
     * @param pageSize  指定一页显示的记录数
     * @return
     */
    PaginationVO <T> queryPaginationVO(T condition, int pageIndex, int pageSize);
}