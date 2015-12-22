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

/**
 * 功能：TODO
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
	public Object querySmRoleList(@RequestBody SmRole condition, int page, int rows) {
		return smRoleService.queryPaginationVO(condition, page, rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveSmRole(@RequestBody SmRole smRole){
		return smRoleService.doSave(smRole);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateSmRole(@PathVariable String id){
		return smRoleService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateSmRole(@PathVariable String id){
		return smRoleService.doRevalidate(id);
	}


}