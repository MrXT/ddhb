
package com.cht.ddhb.common.web.vo;

import java.util.List;

import com.cht.ddhb.domain.CmArea;
import com.cht.ddhb.domain.CmShop;
import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.domain.SmRole;
import com.cht.ddhb.domain.SmUser;


public class SmUserVo extends SmUser{
    private static final long serialVersionUID = -3178813338464407156L;
    /*
     * 登录验证码
     */
    private String vcode;
    /*
     * 用户资源
     */
    private List<SmRes> reses;
    /*
     * 用户角色
     */
    private SmRole role;
    private CmArea area;
    private CmShop shop;
    
    public CmArea getArea() {
        return area;
    }


    public void setArea(CmArea area) {
        this.area = area;
    }

    
    public CmShop getShop() {
        return shop;
    }

    
    public void setShop(CmShop shop) {
        this.shop = shop;
    }

    public SmRole getRole() {
        return role;
    }
    
    public void setRole(SmRole role) {
        this.role = role;
    }

    public String getVcode() {
        return vcode;
    }
    
    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
    
    public List<SmRes> getReses() {
        return reses;
    }
    
    public void setReses(List<SmRes> reses) {
        this.reses = reses;
    }
    
}

