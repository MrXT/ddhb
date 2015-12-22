package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmConmision;
import com.cht.ddhb.module.cm.service.CmConmisionService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/conmision")
public class CmConmisionController {

	@Autowired
	private CmConmisionService cmConmisionService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmConmisionList(@RequestBody CmConmision condition) {
		return cmConmisionService.queryByCondition(condition);
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
	public Object queryCmConmisionList(@RequestBody CmConmision condition, int page, int rows) {
		return cmConmisionService.queryPaginationVO(condition, page, rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmConmision(@RequestBody CmConmision cmConmision){
		return cmConmisionService.doSave(cmConmision);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmConmision(@PathVariable String id){
		return cmConmisionService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmConmision(@PathVariable String id){
		return cmConmisionService.doRevalidate(id);
	}


}