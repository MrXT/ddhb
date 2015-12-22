package com.cht.ddhb.module.cm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.CmShop;
import com.cht.ddhb.module.cm.service.CmShopService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/cm/shop")
public class CmShopController {

	@Autowired
	private CmShopService cmShopService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object queryCmShopList(@RequestBody CmShop condition) {
		return cmShopService.queryByCondition(condition);
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
	public Object queryCmShopPageList(@RequestBody CmShop condition) {
		return cmShopService.queryPaginationVO(condition);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSaveCmShop(@RequestBody CmShop cmShop){
		return cmShopService.doSave(cmShop);
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidateCmShop(@PathVariable String id){
		return cmShopService.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidateCmShop(@PathVariable String id){
		return cmShopService.doRevalidate(id);
	}


}