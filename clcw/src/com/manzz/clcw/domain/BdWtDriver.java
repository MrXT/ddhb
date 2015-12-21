/**
 * create by XXXX
 * @date 2015-09-16
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;
import java.util.Date;

public class BdWtDriver extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  司机编号
     */
    @IdKey
    private String driverId;

    /**
     *  司机姓名
     */
    private String fullname;

    /**
     *  司机年龄
     */
    private Integer age;

    /**
     *  驾龄
     */
    private Integer drivingyears;

    /**
     *  联系方式
     */
    private String phone;

    /**
     *  驾驶证号
     */
    private String drivinglicense;

    /**
     *  从业资格证号
     */
    private String certificatenumber;

    /**
     *  所属公司
     */
    private String company;

    /**
     *  添加时间
     */
    private Date createdate;

    /**
     *  是否冻结（1，冻结）（0，未冻结）
     */
    private String freeze;

    /**
     *  
     */
    private String idcardno;

    /**
     *  
     */
    private String drivingtype;

    /**
     *  
     */
    private String sex;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDrivingyears() {
        return drivingyears;
    }

    public void setDrivingyears(Integer drivingyears) {
        this.drivingyears = drivingyears;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDrivinglicense() {
        return drivinglicense;
    }

    public void setDrivinglicense(String drivinglicense) {
        this.drivinglicense = drivinglicense == null ? null : drivinglicense.trim();
    }

    public String getCertificatenumber() {
        return certificatenumber;
    }

    public void setCertificatenumber(String certificatenumber) {
        this.certificatenumber = certificatenumber == null ? null : certificatenumber.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }

    public String getIdcardno() {
        return idcardno;
    }

    public void setIdcardno(String idcardno) {
        this.idcardno = idcardno == null ? null : idcardno.trim();
    }

    public String getDrivingtype() {
        return drivingtype;
    }

    public void setDrivingtype(String drivingtype) {
        this.drivingtype = drivingtype == null ? null : drivingtype.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
}