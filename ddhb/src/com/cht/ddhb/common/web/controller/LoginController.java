package com.cht.ddhb.common.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.domain.SmUser;
import com.cht.framework.core.common.Constants;
import com.cht.framework.core.model.ResponseJson;

/**
 * 功能：登录控制
 * @author WJK
 * @version:1.0 2015-09
 */
@Controller
public class LoginController {

    /** 功能：显示登录页 */
    @RequestMapping(value = "/index")
    public String showLoginPage() {
        return "common/login";
    }
    
    /** 功能：未登录时访问系统受限页面则会强制退出系统 */
    @RequestMapping(value = "/nosession")
    public String onNoSession(Model model) {
        model.addAttribute("msg", "登录超时，请重新登录");
        return "common/login";
    }
    /** 功能：进入主页面 */
    @RequestMapping(value = "/main")
    public String main(Model model) {
        return "common/main";
    }
    /**
     * 功能:登录验证
     * @param username
     * @param password
     * @return
     */
    /*@RequestMapping(value="/login/{id}",method=RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, @RequestBody User user,@PathVariable String id,String username){
        session.setAttribute(Constants.DEFAULT_SESSION_USER, user);
        System.out.println(((User)session.getAttribute(Constants.DEFAULT_SESSION_USER)).getUsername());
        ResponseJson json = new ResponseJson();
        json.setMsg("登录成功！");
        json.setSuccess(true);
        return json;
    }*/
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, @RequestBody SmUser user){
        session.setAttribute(Constants.DEFAULT_SESSION_USER, user);
        System.out.println(((SmUser)session.getAttribute(Constants.DEFAULT_SESSION_USER)).getUsername());
        ResponseJson json = new ResponseJson();
        json.setMsg("登录成功！");
        json.setSuccess(true);
        return json;
    }
}
