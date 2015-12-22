package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmProjectorder;
import com.cht.ddhb.module.cm.service.CmProjectorderService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/projectorder")
public class CmProjectorderController {

	@Autowired
	private CmProjectorderService cmProjectorderService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmProjectorderList(@RequestBody CmProjectorder condition) {
		return cmProjectorderService.queryByCondition(condition);
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
	public Object queryCmProjectorderPageList(@RequestBody CmProjectorder condition) {
		return cmProjectorderService.queryPaginationVO(condition);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmProjectorder(@RequestBody CmProjectorder cmProjectorder){
		return cmProjectorderService.doSave(cmProjectorder);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmProjectorder(@PathVariable String id){
		return cmProjectorderService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmProjectorder(@PathVariable String id){
		return cmProjectorderService.doRevalidate(id);
	}


}