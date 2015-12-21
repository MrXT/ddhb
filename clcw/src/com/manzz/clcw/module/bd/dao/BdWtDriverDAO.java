/**
 * create by XT
 * @date 2015-09-16
 */
package com.manzz.clcw.module.bd.dao;

import java.util.List;

import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.framework.core.model.PaginationDAO;

public interface BdWtDriverDAO extends PaginationDAO<BdWtDriver> {

    /**
     * 功能:查询手机号或者从业证号相关的司机信息
     * @param condition
     * @return
     */
    List<BdWtDriver> queryDriverByPhoneOrCertificatenumber(BdWtDriver condition);
}