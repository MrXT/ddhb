
package com.manzz.yz.vo;

/**
 * 查询的实体条件
 * 
 * ClassName: Parameter <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class Parameter {
    /**
     * 所属地区
     */
    private String ssdq;
    /**
     * 所属县所
     */
    private String ssxs;
    /**
     * 名称
     */
    private String mc;
    /**
     * 报名起始时间
     */
    private String begin;
    /**
     * 报名结束时间
     */
    private String end;
    /**
     * 驾校id
     */
    private String drivecode;
    
    public Parameter(String ssdq, String ssxs, String mc,String begin,String end) {
        super();
        this.ssdq = ssdq;
        this.ssxs = ssxs;
        this.mc = mc;
        this.begin = begin;
        this.end = end;
    }
    public Parameter(String ssdq, String ssxs, String mc,String begin,String end,String drivecode) {
        super();
        this.ssdq = ssdq;
        this.ssxs = ssxs;
        this.mc = mc;
        this.begin = begin;
        this.end = end;
        this.drivecode = drivecode;
    }

    public String getSsdq() {
        return ssdq;
    }
    
    public void setSsdq(String ssdq) {
        this.ssdq = ssdq;
    }
    
    public String getSsxs() {
        return ssxs;
    }
    
    public void setSsxs(String ssxs) {
        this.ssxs = ssxs;
    }
    
    public String getMc() {
        return mc;
    }
    
    public void setMc(String mc) {
        this.mc = mc;
    }

    
    public String getBegin() {
        return begin;
    }

    
    public void setBegin(String begin) {
        this.begin = begin;
    }

    
    public String getEnd() {
        return end;
    }

    
    public void setEnd(String end) {
        this.end = end;
    }

    
    public String getDrivecode() {
        return drivecode;
    }

    
    public void setDrivecode(String drivecode) {
        this.drivecode = drivecode;
    }
    
    
}

