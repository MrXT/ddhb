package com.cht.ddhb.module.sm.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.module.sm.service.SmResService;
import com.cht.framework.core.exception.BusinessException;

/**
 * 功能：权限管理
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/sm/res")
public class SmResController {

    @Autowired
    private SmResService smResService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmResList(@RequestBody SmRes condition) {
        return smResService.queryByCondition(condition);
    }

    /**
     * 功能:分页查询
     * @param condition
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmResPageList(@RequestBody SmRes condition) {
        return smResService.queryPaginationVO(condition);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object doSaveSmRes(@RequestBody SmRes smRes) {
        SmRes res = new SmRes();
        res.setName(smRes.getName());
        res.setId(smRes.getResId());
        if (!smResService.queryUniquenessBycondition(res)) {
            throw new BusinessException("资源名唯一性检验失败!");
        }
        return smResService.doSaveRes(smRes);
    }

    /**
     * 功能:无效
     * @param id
     * @return
     */
    @RequestMapping(value = "/invalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doInvalidateSmRes(@PathVariable String id) {
        return smResService.doInvalidate(id);
    }

    /**
     * 功能:有效
     * @param id
     * @return
     */
    @RequestMapping(value = "/revalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doRevalidateSmRes(@PathVariable String id) {
        return smResService.doRevalidate(id);
    }
    
    /**
     * 功能：查询可分配给角色的资源树
     * @param id
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    @ResponseBody
    public Object queryResTree() {
        return smResService.doBuildResZTreeNodes();
    }
    
    /**
     * 功能：批量分配角色资源
     * @param id
     */
    @RequestMapping(value = "/batchRoleRes", method = RequestMethod.POST)
    @ResponseBody
    public Object doBatchRoleRes(@RequestBody SmUserVo user) {
        return smResService.doBatchRoleRes(user.getRoleId(),user.getReses());
    }

}