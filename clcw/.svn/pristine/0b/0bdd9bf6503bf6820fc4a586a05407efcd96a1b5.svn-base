
package com.manzz.clcw.module.sm.web.vo;

import java.util.ArrayList;
import java.util.List;

import com.manzz.clcw.domain.SmFunction;
import com.manzz.clcw.domain.SmRole;
import com.manzz.clcw.domain.SmUser;


public class SmUserVo extends SmUser {
    /**
     */
    private static final long serialVersionUID = 721995658118164163L;
    /* 级联对象 */
    private List<SmRole> roleList = new ArrayList<SmRole>();
    private List<SmFunction> functionList = new ArrayList<SmFunction>();
    //关联公司
    private SmUserInfoVo userInfo;
    
    public List<SmRole> getRoleList() {
        return roleList;
    }
    
    public void setRoleList(List<SmRole> roleList) {
        this.roleList = roleList;
    }
    
    
    public List<SmFunction> getFunctionList() {
        return functionList;
    }
    
    public void setFunctionList(List<SmFunction> functionList) {
        this.functionList = functionList;
    }

    public SmUserInfoVo getUserInfo() {
        return userInfo;
    }
    
    public void setUserInfo(SmUserInfoVo userInfo) {
        this.userInfo = userInfo;
    }
    
    
}

