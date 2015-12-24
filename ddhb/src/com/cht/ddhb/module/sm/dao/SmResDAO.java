/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.module.sm.dao;

import java.util.List;
import java.util.Map;

import com.cht.ddhb.domain.SmRes;
import com.cht.framework.core.model.PaginationDAO;

public interface SmResDAO extends PaginationDAO<SmRes> {

	/**
	 * 通过roleId查询权限
	 * @param userId
	 * @return
	 */
	List<SmRes> queryResByRoleId(String userId);
	/**
	 * 
	 * 功能:查询该资源的res_sort
	 *
	 * @param smRes
	 * @return
	 */
    Integer queryRealResSort(SmRes smRes);
    /**
     * 功能:根据roleId批量删除
     * @param roleId
     * @return
     */
    Integer deleteBatchResByRoleId(String roleId);
    /**
     * 功能:批量插入RoleRes
     * @param map
     * @return
     */
    Integer insertBatchRoleRes(Map<String, Object> map);

}