/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.module.sm.dao;

import java.util.List;

import com.cht.ddhb.domain.SmRes;
import com.cht.framework.core.model.PaginationDAO;

public interface SmResDAO extends PaginationDAO<SmRes> {

	/**
	 * 通过roleId查询权限
	 * @param userId
	 * @return
	 */
	List<SmRes> queryResByRoleId(String userId);
}