
package com.manzz.clcw.module.sm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.SmRole;
import com.manzz.clcw.domain.SmUser;
import com.manzz.clcw.module.sm.service.SmRoleService;
import com.manzz.clcw.module.sm.service.SmUserService;
import com.manzz.clcw.module.sm.web.vo.UserVo;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.model.ResponseJson;
/**
 * 用户管理
 * ClassName: UserController <br/>
 * @author XT
 * @version 2015年9月17日
 */
@Controller
public class UserController {
    @Autowired
    private SmUserService userService;
    @Autowired
    private SmRoleService roleService;
    
    /**
     * 功能:跳转到账户管理界面
     * @return
     */
    @RequestMapping(value="/Management/Account")
    public String account(){
        return "Management/Account";
    }
    /**
     * 功能:(根据当前用户的信息（是否是超级管理员）查询所有的用户). <br/>
     * @return
     */
    @RequestMapping(value="/Management/SearchAccount")
    @ResponseBody
    public Object searchAccount(){
        return userService.queryUsersByCurrentUser(SessionHolder.getCurrentUser());
    }
    /**
     * 功能:创建用户
     * @return
     */
    @RequestMapping(value="/Management/CreateAccount")
    @ResponseBody
    public Object createAccount(UserVo user){
        user.setCompanyId(SessionHolder.getCompanyId());
        user.setDefaultValue();
        return userService.doSaveUserAndUserInfo(user);
    }
    @RequestMapping(value="/Management/DeleteAccount")
    @ResponseBody
    public Object deleteAccount(String userId){
        return userService.doDelete(userId);
    }
    /**
     * 功能:查询出超级管理员外的所有角色
     * @param smRole
     * @return
     */
    @RequestMapping(value="/Management/SearchRole")
    @ResponseBody
    public Object searchRole(String userId){
        return roleService.queryByConditionNoSuper(new SmRole());
    }
    /**
     * 功能:
     * @param userId
     * @return
     */
    @RequestMapping(value="/Management/ValidUserName")
    @ResponseBody
    public ResponseJson validUserName(SmUser user){
        ResponseJson json = new ResponseJson();
        List<SmUser> users = userService.queryByCondition(user);
        if(users.size()>0){
            json.setSuccess(false);
            json.setMsg("已有相同的账户，请跟换账户名！");
        }else{
            json.setSuccess(true);
        }
        return json;
    }

}

