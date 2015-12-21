package com.manzz.clcw.module.sm.service;

import com.manzz.clcw.domain.SmUser;
import com.manzz.clcw.module.sm.web.vo.SmUserVo;
import com.manzz.clcw.module.sm.web.vo.UserVo;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationService;
/**
 * 功能：TODO
 * @author XT
 * @version:2015-9-11
 */
public interface SmUserService extends PaginationService<SmUser>{

    /**
     * 功能:(通过用户名查询用户信息). <br/>
     * @param loginName
     * @return
     */
    SmUserVo queryByAccount(String account);
    /**
     * 功能:(根据当前用户的信息（是否是超级管理员）查询所有的用户). <br/>
     * @param currentUser
     * @return
     */
    ResponseJson queryUsersByCurrentUser(SmUserVo currentUser);
    /**
     * 
     * 功能:保存用户的同时保存userinfo与更新user_to_role表)
     * @author XT
     * @param user
     * @return
     */
    int doSaveUserAndUserInfo(UserVo user);

}