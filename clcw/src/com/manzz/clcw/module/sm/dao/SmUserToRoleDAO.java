/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.sm.dao;

import com.manzz.clcw.domain.SmUserToRole;
import com.manzz.framework.core.model.PaginationDAO;

public interface SmUserToRoleDAO extends PaginationDAO<SmUserToRole> {

    int updateByPrimaryKeySelective(SmUserToRole userToRole);
}