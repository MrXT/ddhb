package com.cht.ddhb.module.sm.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cht.ddhb.domain.SmUser;
import com.cht.ddhb.module.sm.service.SmUserService;

/**
 * 功能：TODO
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/sm/user")
public class SmUserController {

    @Autowired
    private SmUserService smUserService;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmUserList(@RequestBody SmUser condition) {
        return smUserService.queryByCondition(condition);
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
    public Object querySmUserPageList(@RequestBody SmUser condition) {
        return smUserService.queryPaginationVO(condition);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object doSaveSmUser(@RequestBody SmUser smUser) {
        return smUserService.doSave(smUser);
    }

    /**
     * 功能:无效
     * @param id
     * @return
     */
    @RequestMapping(value = "/invalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doInvalidateSmUser(@PathVariable String id) {
        return smUserService.doInvalidate(id);
    }

    /**
     * 功能:有效
     * @param id
     * @return
     */
    @RequestMapping(value = "/revalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doRevalidateSmUser(@PathVariable String id) {
        return smUserService.doRevalidate(id);
    }

}