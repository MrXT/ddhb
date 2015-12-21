/**
 * create by XXXX
 * @date 2015-09-14
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;

import java.util.Date;

public class FmWtSecurityrecord extends BaseEntity {

	private static final long serialVersionUID = -8015533188701735848L;

	/**
     *  安检记录编号
     */
	@IdKey
    private String id;

    /**
     *  包车单编号(废)
     */
    private Integer charteredid;

    /**
     *  所属车辆
     */
    private String licenseplate;

    /**
     *  安检状态(0:待检，1：通过，-1：不通过)
     */
    private Integer checkstatus;

    /**
     *  安检员
     */
    private String inspector;

    /**
     *  安检时间
     */
    private Date checkdatetime;

    /**
     *  所属公司
     */
    private String company;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCharteredid() {
        return charteredid;
    }

    public void setCharteredid(Integer charteredid) {
        this.charteredid = charteredid;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
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
        this.inspector = inspector == null ? null : inspector.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCheckdatetime() {
        return checkdatetime;
    }

    public void setCheckdatetime(Date checkdatetime) {
        this.checkdatetime = checkdatetime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}