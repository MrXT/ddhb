package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmOrderAudit;
import com.cht.ddhb.module.cm.service.CmOrderAuditService;

/**
 * 功能：訂單審釘
 * @author XT
 * @version:2015-12-28
 */
@Controller
@RequestMapping("/cm/orderAudit")
public class CmOrderAuditController {

	@Autowired
	private CmOrderAuditService cmOrderAuditService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmOrderAuditList(@RequestBody CmOrderAudit condition) {
		return cmOrderAuditService.queryByCondition(condition);
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
	public Object queryCmOrderAuditVoList(@RequestBody CmOrderAudit condition) {
		return cmOrderAuditService.queryPaginationVO(condition);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmOrderAudit(@RequestBody CmOrderAudit cmOrderAudit){
		return cmOrderAuditService.doSave(cmOrderAudit);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmOrderAudit(@PathVariable String id){
		return cmOrderAuditService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmOrderAudit(@PathVariable String id){
		return cmOrderAuditService.doRevalidate(id);
	}


}