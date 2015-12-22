package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmConmisionsetting;
import com.cht.ddhb.module.cm.service.CmConmisionsettingService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/conmisionsetting")
public class CmConmisionsettingController {

	@Autowired
	private CmConmisionsettingService cmConmisionsettingService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmConmisionsettingList(@RequestBody CmConmisionsetting condition) {
		return cmConmisionsettingService.queryByCondition(condition);
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
	public Object queryCmConmisionsettingList(@RequestBody CmConmisionsetting condition, int page, int rows) {
		return cmConmisionsettingService.queryPaginationVO(condition, page, rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmConmisionsetting(@RequestBody CmConmisionsetting cmConmisionsetting){
		return cmConmisionsettingService.doSave(cmConmisionsetting);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmConmisionsetting(@PathVariable String id){
		return cmConmisionsettingService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmConmisionsetting(@PathVariable String id){
		return cmConmisionsettingService.doRevalidate(id);
	}


}