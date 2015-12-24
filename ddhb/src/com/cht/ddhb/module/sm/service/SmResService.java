package com.cht.ddhb.module.sm.service;

import java.util.List;

import com.cht.ddhb.domain.SmRes;
import com.cht.framework.core.service.PaginationService;
import com.cht.framework.core.web.ztree.SimpleZTreeData;
/**
 * @author XT
 * @version:2015-12-22
 */
public interface SmResService extends PaginationService<SmRes>{

    /**
     * 功能:根据资源的list构造出zTree所需要的对象
     * @return 
     */
    List<SimpleZTreeData> doBuildResZTreeNodes();

    /**
     * 保存资源
     * @author XT
     * @param smRes
     * @return
     */
    Integer doSaveRes(SmRes smRes);

    /**
     * 功能:批量保存
     * @author XT
     * @param user
     * @return
     */

    Integer doBatchRoleRes(String roleId, List<SmRes> reses);

}