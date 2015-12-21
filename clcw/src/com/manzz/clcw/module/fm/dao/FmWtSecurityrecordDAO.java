/**
 * create by XXXX
 * @date 2015-09-14
 */
package com.manzz.clcw.module.fm.dao;

import java.util.Map;

import com.manzz.clcw.domain.FmWtSecurityrecord;
import com.manzz.framework.core.model.PaginationDAO;

public interface FmWtSecurityrecordDAO extends PaginationDAO<FmWtSecurityrecord> {

    int updateCheckStatusByLicenseplate(Map<String,Object> map);
}