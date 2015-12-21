package com.manzz.clcw.common.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.SmRole;
import com.manzz.clcw.module.sm.service.SmUserService;
import com.manzz.clcw.module.sm.web.vo.SmUserVo;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.model.ResponseJson;

/**
 * 功能：登录控制
 * @author WJK
 * @version:1.0 2015-09
 */
@Controller
public class LoginController {
    @Autowired
    private SmUserService userService;

    /** 功能：显示登录页 */
    @RequestMapping(value = "/index")
    public String showLoginPage(HttpSession session) {
        if(session.getAttribute(Constants.DEFAULT_SESSION_USER) == null){
            return "common/login";
        }else{
            return "Frequency/Index"; 
        }
        
    }

    /** 功能：未登录时访问系统受限页面则会强制退出系统 */
    @RequestMapping(value = "/nosession")
    public String onNoSession(Model model) {
        model.addAttribute("msg", "登录超时，请重新登录");
        return "common/login";
    }
    /** 功能：退出系统 */
    @RequestMapping(value = "/System/Logout" ,method = RequestMethod.POST)
    @ResponseBody
    public Object relogin(Model model,HttpSession session) {
        session.removeAttribute(Constants.DEFAULT_SESSION_USER);
        ResponseJson json = new ResponseJson();
        json.setUrl("index");
        return json;
    }
    
    /** 功能：执行登录 */
    @RequestMapping(value = "/Login/LogOn", method = RequestMethod.POST)
    @ResponseBody
    public Object loginValid(@RequestParam String USER_NAME, @RequestParam String USER_PASSWORD, Model model,HttpSession session) {
        ResponseJson json = new ResponseJson();
        SmUserVo user = userService.queryByAccount(USER_NAME);
        if (user == null) {
            json.setCode(-1);
            json.setMsg("用户不存在");
        } else if (!user.getUserPassword().equals(USER_PASSWORD)) {
            json.setCode(-1);
            json.setMsg("密码错误");
        } else if(user.getRoleList().size() != 0){
            boolean canLogin = false;
            for (SmRole  role : user.getRoleList()) {
                if(!role.getRoleName().equals(Constants.TELLER_OFFICER) && !role.getRoleName().equals(Constants.SECURITY_OFFICER)){
                    canLogin = true;
                }
            }
            if(canLogin){
                json.setCode(1);
                session.setAttribute(Constants.DEFAULT_SESSION_USER, user);
                json.setUrl("Frequency/Index");//跳转到班次发布
            }else{
                json.setCode(-1);
                json.setMsg("安检员与检票员不能登录后台！");
            }
            
        }
        return json;
    }
}
