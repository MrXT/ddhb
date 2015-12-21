
package com.manzz.clcw.module.bd.web.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.clcw.domain.BdWtCars;
import com.manzz.framework.core.web.serializer.CustomDateTimeSerializer;


public class BdWtCarsVo extends BdWtCars {
    private static final long serialVersionUID = -1327239909233258578L;
    private String securityrecordId;
    private Integer checkstatus;
    private String inspector;
    private Date checkdatetime;
    
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getCheckdatetime() {
        return checkdatetime;
    }
    
    public void setCheckdatetime(Date checkdatetime) {
        this.checkdatetime = checkdatetime;
    }

    private String checkstatusName;
    
    
    public String getCheckstatusName() {
        return checkstatusName;
    }

    
    public void setCheckstatusName(String checkstatusName) {
        this.checkstatusName = checkstatusName;
    }

    public String getSecurityrecordId() {
        return securityrecordId;
    }
    
    public void setSecurityrecordId(String securityrecordId) {
        this.securityrecordId = securityrecordId;
    }
    
    public Integer getCheckstatus() {
        return checkstatus;
    }
    
    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }
    
    public String getInspector() {
        return inspector;
    }
    
    public void setInspector(String inspector) {
        this.inspector = inspector;
    }
    
    
}   

