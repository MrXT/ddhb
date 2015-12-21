package com.manzz.clcw.module.sm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmFunction;
import com.manzz.clcw.domain.SmUser;
import com.manzz.clcw.domain.SmUserInfo;
import com.manzz.clcw.domain.SmUserToRole;
import com.manzz.clcw.module.sm.dao.SmFunctionDAO;
import com.manzz.clcw.module.sm.dao.SmRoleDAO;
import com.manzz.clcw.module.sm.dao.SmUserDAO;
import com.manzz.clcw.module.sm.dao.SmUserInfoDAO;
import com.manzz.clcw.module.sm.dao.SmUserToRoleDAO;
import com.manzz.clcw.module.sm.service.SmUserService;
import com.manzz.clcw.module.sm.web.vo.SmUserInfoVo;
import com.manzz.clcw.module.sm.web.vo.SmUserVo;
import com.manzz.clcw.module.sm.web.vo.UserVo;
import com.manzz.clcw.domain.SmRole;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-11
 */
public class SmUserServiceImpl extends PaginationServiceImpl<SmUser> implements SmUserService{
	@Autowired
	private SmUserDAO smUserDAO;

	@Autowired
	private SmRoleDAO roleDAO; 
	@Autowired
	private SmUserToRoleDAO userToRoleDAO; 
	
	@Autowired
	private SmFunctionDAO functionDAO; 
	@Autowired
	
	private SmUserInfoDAO userInfoDAO; 
    @Override
    public SmUserVo queryByAccount(String account) {
        SmUser user = new SmUser();
        user.setUserName(account);
        List<SmUser> users = queryByCondition(user);
        user = users.size() != 0?users.get(0):null;
        SmUserVo vo = null;
        if(user != null){
            vo = new SmUserVo(); 
            BeanUtils.copyProperties(user, vo);
            String userId = user.getUserId();
            //加载角色信息
            List<SmRole> roleList = roleDAO.queryUserRoles(userId);
            vo.setRoleList(roleList);
            //加载用户资源
            List<SmFunction> functionList = functionDAO.queryUserResByType(userId);
            vo.setFunctionList(functionList);
            //加载用户所在公司
            List<SmUserInfoVo> infos = userInfoDAO.queryUserInfoVoByUserId(userId);
            vo.setUserInfo(infos.size() != 0?infos.get(0):null);
        }
        return vo;
    }
    @Override
    public ResponseJson queryUsersByCurrentUser(SmUserVo currentUser) {
        ResponseJson json = new ResponseJson();
        List<SmRole> roles = currentUser.getRoleList();
        for (SmRole smRole : roles) {
            if(Constants.SUPER_MANAGER.equals(smRole.getRoleName())){
                UserVo user = new UserVo();
                user.setRoleName(Constants.SUPER_MANAGER);
                user.setCompanyId(currentUser.getUserInfo().getCompany());
                List<UserVo> users = smUserDAO.queryUserRole(user);
                json.setData(users);
                break;
            }
        }
        return json;
    }
    @Override
    public int doSaveUserAndUserInfo(UserVo userVo) {
        SmUser user = new SmUser();
        user.setUserName(userVo.getUserName());
        user.setUserPassword(userVo.getUserPassword());
        user.setOperId(userVo.getOperId());
        if(userVo.getUserId() != null && !userVo.getUserId().equals("")){
            user.setUserId(userVo.getUserId());
            smUserDAO.updateByPrimaryKeySelective(user);
            SmUserToRole userToRole = new SmUserToRole();
            userToRole.setUserId(userVo.getUserId());
            userToRole.setRoleId(userVo.getRoleId());
            userToRole.setOperId(userVo.getOperId());
            return userToRoleDAO.updateByPrimaryKeySelective(userToRole);
        }
        if(smUserDAO.insert(user) == 1){
            SmUserInfo userInfo = new SmUserInfo();
            userInfo.setUserId(user.getUserId());
            userInfo.setCompany(userVo.getCompanyId());
            userInfo.setOperId(userVo.getOperId());
            userInfoDAO.insert(userInfo);
            SmUserToRole userToRole = new SmUserToRole();
            userToRole.setUserId(user.getUserId());
            userToRole.setRoleId(userVo.getRoleId());
            userToRole.setOperId(userVo.getOperId());
            return userToRoleDAO.insert(userToRole);
        }
        return 0;
    }
}
