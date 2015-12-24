/**
 * create by root
 * @date 2015-12-22
 */
package com.cht.ddhb.module.sm.dao;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.SmUser;
import com.cht.framework.core.model.PaginationDAO;

public interface SmUserDAO extends PaginationDAO<SmUser> {

	/**
	 * 通过用户名去查找用户
	 * @param username
	 * @return
	 */
	SmUserVo queryUserByUsername(String username);
}