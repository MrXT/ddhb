package com.manzz.clcw.module.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmRole;
import com.manzz.clcw.module.sm.dao.SmRoleDAO;
import com.manzz.clcw.module.sm.service.SmRoleService;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-11
 */
public class SmRoleServiceImpl extends PaginationServiceImpl<SmRole> implements SmRoleService{
	@Autowired
	private SmRoleDAO dao;

    @Override
    public List<SmRole> queryByConditionNoSuper(SmRole smRole) {
        List<SmRole> roles = dao.queryPagedList(smRole);
        //移除超级管理员
        for (int i=0;i<roles.size();i++) {
            if(Constants.SUPER_MANAGER.equals(roles.get(i).getRoleName())){
                roles.remove(i);
                if(i!=0){
                    i--;
                }
            }
        }
        return roles;
    }
}
