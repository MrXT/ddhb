
package com.cht.ddhb.common.web.vo;

import java.util.List;

import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.domain.SmUser;


public class SmUserVo extends SmUser{
    private static final long serialVersionUID = -3178813338464407156L;
    private String vcode;
    private List<SmRes> reses;
    
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

