/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.sm.dao;

import java.util.List;

import com.manzz.clcw.domain.SmUserInfo;
import com.manzz.clcw.module.sm.web.vo.SmUserInfoVo;
import com.manzz.framework.core.model.PaginationDAO;

public interface SmUserInfoDAO extends PaginationDAO<SmUserInfo> {
    
    /**
     * 
     * 功能:(通过用户id加载user信息). <br/>
     *
     * @author XT
     * @param userId
     * @return
     */
    List<SmUserInfoVo> queryUserInfoVoByUserId(String userId);
}