package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.domain.CmArea;
import com.cht.ddhb.module.cm.service.CmAreaService;

/**
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/area")
public class CmAreaController {

	@Autowired
	private CmAreaService cmAreaService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmAreaList(@RequestBody CmArea condition) {
		return cmAreaService.queryByCondition(condition);
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
	public Object queryCmAreaPageList(@RequestBody CmArea condition) {
		return cmAreaService.queryPaginationVO(condition);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmArea(@RequestBody CmArea cmArea){
		return cmAreaService.doSave(cmArea);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmArea(@PathVariable String id){
		return cmAreaService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmArea(@PathVariable String id){
		return cmAreaService.doRevalidate(id);
	}


}