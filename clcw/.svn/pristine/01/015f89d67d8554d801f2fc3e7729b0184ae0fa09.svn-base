/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manzz.clcw.domain.SmUser;
import com.manzz.clcw.module.sm.web.vo.UserVo;
import com.manzz.clcw.module.ws.vo.CheckUserVO;
import com.manzz.framework.core.model.PaginationDAO;

public interface SmUserDAO extends PaginationDAO<SmUser> {

    List<UserVo> queryUserRole(UserVo user);
    
    CheckUserVO queryCheck(@Param("username") String username,@Param("roleName") String roleName);
}