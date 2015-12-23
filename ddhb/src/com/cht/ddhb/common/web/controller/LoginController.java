package com.cht.ddhb.common.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.common.enums.constant.StatusEnum;
import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.module.sm.service.SmUserService;
import com.cht.framework.core.common.Constants;
import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.model.ResponseJson;
import com.cht.framework.core.util.ValidateCodeUtil;

/**
 * 功能：登录控制
 * @author XT
 * @version:1.0 2015-09
 */
@Controller
public class LoginController {

    @Autowired
    private SmUserService userService;

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
    /**
     * 功能:没有权限
     *
     * @author XT
     * @return
     */
    @RequestMapping(value = "/nores")
    @ResponseBody
    public Object onNores() {
        throw new BusinessException("沒有足够的权限!");
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
    /*
     * @RequestMapping(value="/login/{id}",method=RequestMethod.POST)
     * @ResponseBody public Object login(HttpSession session, @RequestBody User
     * user,@PathVariable String id,String username){
     * session.setAttribute(Constants.DEFAULT_SESSION_USER, user);
     * System.out.println
     * (((User)session.getAttribute(Constants.DEFAULT_SESSION_USER
     * )).getUsername()); ResponseJson json = new ResponseJson();
     * json.setMsg("登录成功！"); json.setSuccess(true); return json; }
     */
    @RequestMapping(value = "/login/valid", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, @RequestBody SmUserVo userVo) {
        ResponseJson json = new ResponseJson();
        String vcode = userVo.getVcode();
        if (session.getAttribute("vcode") == null) {
            json.setMsg("验证码失效!");
        } else {
            if (vcode != null && vcode.toUpperCase().equals(session.getAttribute("vcode"))) {// 验证码
                SmUserVo user = userService.queryUserVoByUsername(userVo.getUsername());
                if (user == null) {
                    json.setMsg("用户不存在!");
                } else if (!user.getPassword().equals(userVo.getPassword())) {
                    /**
                     * TODO 登录失败次数的计算
                     */
                    json.setMsg("密码错误!");
                } else if (StatusEnum.INVALID.getBooleanValue().equals(user.getValidity())) {
                    json.setMsg("账号被封不可用!");
                } else {
                    json.setSuccess(true);
                    session.setAttribute(Constants.DEFAULT_SESSION_USER, user);
                                          }
            } else {
                json.setMsg("验证码错误!");
                                }
            session.removeAttribute("vcode");
                    }
        return json;
    }

    /**
     * 功能： 1、将验证码信息写入session 2、将验证码以图片形式写入response的输出流
     * @throws IOException
     */
    @RequestMapping(value = "/vcode")
    public void showValidateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String vcode = ValidateCodeUtil.createRandomCode();
        request.getSession().setAttribute("vcode", vcode);
        ValidateCodeUtil.output(vcode, response.getOutputStream());
    }
}
