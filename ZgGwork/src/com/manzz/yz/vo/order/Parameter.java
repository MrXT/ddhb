
package com.manzz.yz.vo.order;

/**
 * 预约接口 查询的实体条件
 * 
 * ClassName: Parameter <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class Parameter {
    /**
     * 驾校编号
     */
    private String schoolCode;
    /**
     * 类型（1自贡）
     */
    private Integer type;
    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 第几页
     */
    private String pageIndex;
    /**
     * 开始时间
     */
    private String beginTime;
    /**
     * 结束时间
     */
    private String endTime;
    
    /**
     * 学员身份证或者姓名（模糊查询）
     */
    private String keyStr;
    
    
    public Parameter(Integer type, Integer pageSize, String pageIndex,String beginTime,String endTime) {
        super();
        this.pageSize = pageSize;
        this.type = type;
        this.pageIndex = pageIndex;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
    public Parameter(String schoolCode, Integer pageSize, String pageIndex,String beginTime,String endTime,String keyStr) {
        super();
        this.pageSize = pageSize;
        this.schoolCode = schoolCode;
        this.pageIndex = pageIndex;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.keyStr = keyStr;
    }
    
    public Parameter() {
        super();
    }
    public String getKeyStr() {
        return keyStr;
    }
    
    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }



    public Integer getType() {
        return type;
    }


    
    public void setType(Integer type) {
        this.type = type;
    }


    
    public Integer getPageSize() {
        return pageSize;
    }


    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    
    public String getPageIndex() {
        return pageIndex;
    }


    
    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }


    
    public String getBeginTime() {
        return beginTime;
    }


    
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }


    
    public String getEndTime() {
        return endTime;
    }


    
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getSchoolCode() {
        return schoolCode;
    }
    
    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    
    
}

