
package com.manzz.clcw.module.lm.web.vo;

import java.util.List;

import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.domain.LmWtSites;


public class LmWtClasslineVo extends LmWtClassline {

    private static final long serialVersionUID = 6140755088535973453L;
    
    private int ticketprice;
    
    private String siteName;

    private int frequencytotal;
    
    private String siteName1;
    
    private List<LmWtSites> sites;
    
    
    public List<LmWtSites> getSites() {
        return sites;
    }
    
    public void setSites(List<LmWtSites> sites) {
        this.sites = sites;
    }

    public String getSiteName1() {
        return siteName1;
    }
    
    public void setSiteName1(String siteName1) {
        this.siteName1 = siteName1;
    }


    public int getFrequencytotal() {
        return frequencytotal;
    }

    
    public void setFrequencytotal(int frequencytotal) {
        this.frequencytotal = frequencytotal;
    }


    public int getTicketprice() {
        return ticketprice;
    }

    
    public void setTicketprice(int ticketprice) {
        this.ticketprice = ticketprice;
    }

    
    public String getSiteName() {
        return siteName;
    }

    
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
    
    

}

