package com.cht.ddhb.module.sm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.common.util.ValidateAndThrowUtil;
import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.module.sm.dao.SmResDAO;
import com.cht.ddhb.module.sm.service.SmResService;
import com.cht.framework.core.service.PaginationServiceImpl;
import com.cht.framework.core.web.ztree.SimpleZTreeData;
/**
 * @author XT
 * @version:2015-12-22
 */
public class SmResServiceImpl extends PaginationServiceImpl<SmRes> implements SmResService{
	@Autowired
	private SmResDAO dao;


    @Override
    public List<SimpleZTreeData> doBuildResZTreeNodes() {
        List<SimpleZTreeData> zNodes = new ArrayList<SimpleZTreeData>();
        SimpleZTreeData zNode;
        SmRes resQuery = new SmRes();
        resQuery.setSort("res_sort");
        resQuery.setOrder("asc");
        List<SmRes> resList = dao.queryPagedList(resQuery);
        for (SmRes res : resList) {
            zNode = new SimpleZTreeData(res.getResId(),res.getParentId(),res.getName());
            zNodes.add(zNode);
        }
        return zNodes;
    }


    @Override
    public Integer doSaveRes(SmRes smRes) {
        //根据数据库来查找该资源的排序
        if(smRes.getResId() != null){
            return doUpdate(smRes);
        }else{
            smRes.setResSort(dao.queryRealResSort(smRes));
            return doInsert(smRes);
        }
    }


    @Override
    public Integer doBatchRoleRes(String roleId, List<SmRes> reses) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!ValidateAndThrowUtil.isBlank(roleId) && !ValidateAndThrowUtil.isNullList(reses)){
            map.put("roleId", roleId);
            map.put("reses", reses);
        }
      //先批量删除
        dao.deleteBatchResByRoleId(roleId);
        //在批量增加
        return dao.insertBatchRoleRes(map);
    }
}
