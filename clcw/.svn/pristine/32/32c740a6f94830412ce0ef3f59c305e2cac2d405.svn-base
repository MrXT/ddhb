package com.manzz.clcw.module.lm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.lm.dao.LmWtSitesDAO;
import com.manzz.clcw.module.lm.service.LmWtSitesService;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XXXX
 * @version:2015-9-11
 */
public class LmWtSitesServiceImpl extends PaginationServiceImpl<LmWtSites> implements LmWtSitesService{
	@Autowired
	private LmWtSitesDAO dao;

    @Override
    public LmWtLinesVo queryEndSitesAndStartSitesByCondition(LmWtLinesVo line) {
        LmWtSites site = new LmWtSites();
        site.setLineId(line.getLineId());
        site.setSort("sitenumber");
        site.setOrder("asc");
        List<LmWtSites> sites = queryByCondition(site);
        StringBuffer ssite = new StringBuffer("");
        StringBuffer esite = new StringBuffer("");
        int ssiteCount = 0;
        int esiteCount = 0;
        for (LmWtSites lmsite : sites) {
            if(lmsite.getRegionCode().intValue() == line.getDeparture().intValue()){
                ssite.append(lmsite.getSiteId()+","+lmsite.getSitename()+","+lmsite.getLineId()+","+lmsite.getRegionCode()+","+lmsite.getSitenumber()+"|");
                ssiteCount++;
            }else if(lmsite.getRegionCode().intValue() == line.getDestination().intValue()){
                esite.append(lmsite.getSiteId()+","+lmsite.getSitename()+","+lmsite.getLineId()+","+lmsite.getRegionCode()+","+lmsite.getSitenumber()+"|");
                esiteCount++;
            }
        }
        if(!ssite.toString().equals("")){
            line.setSsite(ssite.append("|"+ssiteCount).toString());
        }
        if(!esite.toString().equals("")){
            line.setEsite(esite.append("|"+esiteCount).toString());
        }
        return line;
    }
}
