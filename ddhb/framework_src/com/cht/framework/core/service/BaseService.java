/**
 * Project Name:dtdp File Name:BaseService.java Package
 * Name:com.cht.framework.core.model Date:2014-09-30下午4:21:05 Copyright (c)
 * 2014, cht.com All Rights Reserved.
 */

package com.cht.framework.core.service;

import java.util.List;

/**
 * ClassName: BaseService <br/>
 * Function: 基础Service. <br/>
 * @author WJK
 * @version 2015-01
 */
public interface BaseService <T> {

    /** 主键查询 */
    T queryByPrimaryKey(String id);

    /** 根据条件进行查询 */
    List<T> queryByCondition(T condition);

    /** 新增 */
    int doInsert(T entity);

    /** 修改 */
    int doUpdate(T entity);

    /** 删除 */
    int doDelete(String id);

    /** 逻辑删除 */
    int doInvalidate(String id);

    /** 逻辑删除 */
    int doInvalidate(T t);

    /** 逻辑恢复 */
    int doRevalidate(String id);

    /** 逻辑恢复 */
    int doRevalidate(T t);

    /** 保存 */
    int doSave(T record);
    /**
     * 功能:属性唯一性校验
     * @author XT
     * @param condition
     * @return
     */
    Boolean queryUniquenessBycondition(T condition);
}
