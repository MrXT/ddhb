/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.sm.dao;

import java.util.List;

import com.manzz.clcw.domain.SmFunction;
import com.manzz.framework.core.model.PaginationDAO;

public interface SmFunctionDAO extends PaginationDAO<SmFunction> {
    
    /**
     * 
     * 功能:(根据userid查询相应的角色功能). <br/>
     *
     * @author XT
     * @param userId
     * @return
     */
    List<SmFunction> queryUserResByType(String userId);
}