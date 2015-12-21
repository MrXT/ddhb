/**
 * create by XXXX
 * @date 2015-09-14
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;
import com.manzz.framework.core.web.serializer.CustomDateTimeSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class FmWtChartered  {
    
    private Integer charteredId;
    
    /**
     * 班次id
     */
    private String frequencyId;
    

    /**
     *  出发地
     */
    private String departure;

    /**
     *  目的地
     */
    private String destination;

    /**
     *  途径线路
     */
    private String wayline;

    /**
     *  发车时间
     */
    private Date departuredatetime;

    /**
     *  收车时间
     */
    private Date destinationdatetime;

    /**
     *  车牌号
     */
    private String licenseplate;

    /**
     *  
     */
    private String licenseplatestr;

    /**
     *  驾驶员
     */
    private String drivername;

    /**
     *  包车单位
     */
    private String charteredcompany;

    /**
     *  包车单位联系人
     */
    private String companyleader;

    /**
     *  包车单位联系人身份证号
     */
    private String leaderidnumber;

    /**
     *  包车单位联系人电话
     */
    private String leaderphone;

    /**
     *  可承载人数
     */
    private Integer passenger;

    /**
     *  预约承载人数
     */
    private Integer orderpassenger;

    /**
     *  安检状态(0:待安检，1:已通过，-1：未通过)
     */
    private Integer checkstatus;

    /**
     *  
     */
    private Date checkdatetime;

    /**
     *  包车价格
     */
    private BigDecimal charteredprice;

    /**
     *  发布时间
     */
    private Date releasedatetime;

    /**
     *  安检员
     */
    private String inspector;

    /**
     *  所属公司
     */
    private String company;
    
    private String operId;
    
    private Date operTime;
    
    
    
    public String getFrequencyId() {
        return frequencyId;
    }
    
    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId;
    }


    public String getOperId() {
        return operId;
    }

    
    public void setOperId(String operId) {
        this.operId = operId;
    }

    
    public Date getOperTime() {
        return operTime;
    }

    
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Integer getCharteredId() {
        return charteredId;
    }
    
    public void setCharteredId(Integer charteredId) {
        this.charteredId = charteredId;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure == null ? null : departure.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getWayline() {
        return wayline;
    }

    public void setWayline(String wayline) {
        this.wayline = wayline == null ? null : wayline.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDeparturedatetime() {
        return departuredatetime;
    }

    public void setDeparturedatetime(Date departuredatetime) {
        this.departuredatetime = departuredatetime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDestinationdatetime() {
        return destinationdatetime;
    }

    public void setDestinationdatetime(Date destinationdatetime) {
        this.destinationdatetime = destinationdatetime;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
    }

    public String getLicenseplatestr() {
        return licenseplatestr;
    }

    public void setLicenseplatestr(String licenseplatestr) {
        this.licenseplatestr = licenseplatestr == null ? null : licenseplatestr.trim();
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername == null ? null : drivername.trim();
    }

    public String getCharteredcompany() {
        return charteredcompany;
    }

    public void setCharteredcompany(String charteredcompany) {
        this.charteredcompany = charteredcompany == null ? null : charteredcompany.trim();
    }

    public String getCompanyleader() {
        return companyleader;
    }

    public void setCompanyleader(String companyleader) {
        this.companyleader = companyleader == null ? null : companyleader.trim();
    }

    public String getLeaderidnumber() {
        return leaderidnumber;
    }

    public void setLeaderidnumber(String leaderidnumber) {
        this.leaderidnumber = leaderidnumber == null ? null : leaderidnumber.trim();
    }

    public String getLeaderphone() {
        return leaderphone;
    }

    public void setLeaderphone(String leaderphone) {
        this.leaderphone = leaderphone == null ? null : leaderphone.trim();
    }

    public Integer getPassenger() {
        return passenger;
    }

    public void setPassenger(Integer passenger) {
        this.passenger = passenger;
    }

    public Integer getOrderpassenger() {
        return orderpassenger;
    }

    public void setOrderpassenger(Integer orderpassenger) {
        this.orderpassenger = orderpassenger;
    }

    public Integer getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(Integer checkstatus) {
        this.checkstatus = checkstatus;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCheckdatetime() {
        return checkdatetime;
    }

    public void setCheckdatetime(Date checkdatetime) {
        this.checkdatetime = checkdatetime;
    }

    public BigDecimal getCharteredprice() {
        return charteredprice;
    }

    public void setCharteredprice(BigDecimal charteredprice) {
        this.charteredprice = charteredprice;
    }

    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getReleasedatetime() {
        return releasedatetime;
    }

    public void setReleasedatetime(Date releasedatetime) {
        this.releasedatetime = releasedatetime;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector == null ? null : inspector.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}