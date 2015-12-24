package com.cht.ddhb.module.sm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.domain.SmRole;
import com.cht.ddhb.module.sm.service.SmRoleService;
import com.cht.framework.core.exception.BusinessException;

/**
 * 功能：角色管理
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/sm/role")
public class SmRoleController {

    @Autowired
    private SmRoleService smRoleService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmRoleList(@RequestBody SmRole condition) {
        return smRoleService.queryByCondition(condition);
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
    public Object querySmRolePageList(@RequestBody SmRole condition) {
        if (condition.getPage() == null || condition.getRows() == null) {
            throw new BusinessException("参数传递错误!");
        }
        return smRoleService.queryPaginationVO(condition);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object doSaveSmRole(@RequestBody SmRole smRole) {
        SmRole role = new SmRole();
        role.setId(smRole.getRoleId());
        role.setName(smRole.getName());
        if (!smRoleService.queryUniquenessBycondition(role)) {
            throw new BusinessException("角色名唯一性检验失败!");
        }
        return smRoleService.doSave(smRole);
    }

    /**
     * 功能:无效
     * @param id
     * @return
     */
    @RequestMapping(value = "/invalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doInvalidateSmRole(@PathVariable String id) {
        return smRoleService.doInvalidate(id);
    }

    /**
     * 功能:有效
     * @param id
     * @return
     */
    @RequestMapping(value = "/revalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doRevalidateSmRole(@PathVariable String id) {
        return smRoleService.doRevalidate(id);
    }

}