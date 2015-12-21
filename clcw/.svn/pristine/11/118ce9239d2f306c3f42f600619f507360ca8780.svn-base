
package com.manzz.clcw.module.cm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.CmWtCompany;
import com.manzz.clcw.module.cm.service.CmWtCompanyService;
import com.manzz.clcw.module.sm.service.SmUserService;
import com.manzz.clcw.module.sm.web.vo.SmUserVo;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.model.ResponseJson;
/**
 * 公司设置控制器
 * ClassName: CompanyController <br/>
 * @author XT
 * @version 2015年9月17日
 */
@Controller
public class CompanyController {
    @Autowired
    private CmWtCompanyService companyService;
    @Autowired
    private SmUserService userService;
    /**
     * 功能:(跳转到公司设置页面). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping("/Management/Index")
    public String vehicles(Model map){
        return "/Management/Index";
    }
    /**
     * 功能:(更改公司名). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping(value ="/Management/Update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(HttpSession session,String oldPassword,String newPassword,String flag,String companyName){
        ResponseJson json = new ResponseJson();
        SmUserVo user = SessionHolder.getCurrentUser();
        //修改密码
        if("1".equals(flag)){
            if(oldPassword.equals(user.getUserPassword())){
                user.setUserPassword(newPassword);
                userService.doUpdate(user);
                session.setAttribute(Constants.DEFAULT_SESSION_USER,user);
                json.setMsg("操作成功");
            }else{
                json.setMsg("请输入正确的旧密码");
            }
            json.setSuccess(true);
        }//修改公司信息
        else if("0".equals(flag)){
           CmWtCompany company = new CmWtCompany();
           company.setCompanyId(SessionHolder.getCompanyId());
           company.setCompanyName(companyName);
           companyService.doUpdate(company);
           user.getUserInfo().setCompanyName(companyName);
           session.setAttribute(Constants.DEFAULT_SESSION_USER,user);
           json.setMsg("操作成功");
           json.setSuccess(true);
        }else{
           json.setMsg("错误请求");
        }
        
        return json;
    }
}

