package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmInnernotice;
import com.cht.ddhb.module.cm.service.CmInnernoticeService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/innernotice")
public class CmInnernoticeController {

	@Autowired
	private CmInnernoticeService cmInnernoticeService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmInnernoticeList(@RequestBody CmInnernotice condition) {
		return cmInnernoticeService.queryByCondition(condition);
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
	public Object queryCmInnernoticeList(@RequestBody CmInnernotice condition, int page, int rows) {
		return cmInnernoticeService.queryPaginationVO(condition, page, rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmInnernotice(@RequestBody CmInnernotice cmInnernotice){
		return cmInnernoticeService.doSave(cmInnernotice);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmInnernotice(@PathVariable String id){
		return cmInnernoticeService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmInnernotice(@PathVariable String id){
		return cmInnernoticeService.doRevalidate(id);
	}


}