package com.cht.ddhb.module.sm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.domain.SmUser;
import com.cht.ddhb.module.sm.dao.SmResDAO;
import com.cht.ddhb.module.sm.dao.SmUserDAO;
import com.cht.ddhb.module.sm.service.SmUserService;
import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-12-22
 */
public class SmUserServiceImpl extends PaginationServiceImpl<SmUser> implements SmUserService{
	@Autowired
	private SmUserDAO dao;
    @Autowired
    private SmResDAO  resDAO;

	@Override
	public SmUserVo queryUserVoByUsername(String username) {
		if(username == null) 
            throw new BusinessException("用户账号不能为空");
		SmUser user = dao.queryUserByUsername(username);
		SmUserVo userVo = null;
		if(user != null){
			userVo = new SmUserVo();
			BeanUtils.copyProperties(user,userVo);
			List<SmRes> reses = null;
			//规则判定用户是不是超级管理员，就是看他的role_id是不是0
			if(user.getRoleId().equals("0")){
				reses = resDAO.queryPagedList(new SmRes());
			}else{
				reses = resDAO.queryResByRoleId(user.getUserId());
			}
			userVo.setReses(reses);
		}
		return userVo;
	}
}
