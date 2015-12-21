package com.manzz.clcw.module.lm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.lm.dao.LmWtClasslineDAO;
import com.manzz.clcw.module.lm.dao.LmWtSitesDAO;
import com.manzz.clcw.module.lm.service.LmWtClasslineService;
import com.manzz.clcw.module.lm.web.vo.LmWtClasslineVo;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-11
 */
public class LmWtClasslineServiceImpl extends PaginationServiceImpl<LmWtClassline> implements LmWtClasslineService{
	@Autowired
	private LmWtClasslineDAO dao;
	@Autowired
	private LmWtSitesDAO siteDAO;

    @Override
    public List<LmWtClasslineVo> queryClassLineByCompany(LmWtLines condition) {
        List<LmWtClasslineVo> classlines = dao.queryClassLineByCompany(condition);
        //将siteList转换为siteName站点名
        List<LmWtClasslineVo> newClasslines = new ArrayList<LmWtClasslineVo>();
        for (LmWtClasslineVo classline : classlines) {
            String[] siteNumbers = classline.getSiteList().split(",");
            List<LmWtSites> sites = dao.querySiteNameBySiteNumbers(siteNumbers);
            classline.setSites(sites);
            StringBuffer siteName = new StringBuffer();
            if(sites!=null &&sites.size() != 0){
                for (LmWtSites lmWtSites : sites) {
                    siteName.append(lmWtSites.getSitename()+",");
                }
                siteName.delete(siteName.length()-1, siteName.length());
                classline.setSiteName(siteName.toString());
               
            }else{
                classline.setSiteName("");
            }
            newClasslines.add(classline);
        }
        return newClasslines;
    }

    @Override
    public List<LmWtClasslineVo> queryByLinesVoByCondition(LmWtLines condition) {
        List<LmWtClasslineVo> classlines = dao.queryClassLineByLine(condition);
        //将siteList转换为siteName站点名
        List<LmWtClasslineVo> newClasslines = new ArrayList<LmWtClasslineVo>();
        for (LmWtClasslineVo classline : classlines) {
            String[] siteNumbers = classline.getSiteList().split(",");
            List<LmWtSites> sites = dao.querySiteNameBySiteNumbers(siteNumbers);
            StringBuffer siteName = new StringBuffer();
            StringBuffer siteName1 = new StringBuffer();
            if(sites!=null &&sites.size() != 0){
                for (LmWtSites lmWtSites : sites) {
                    siteName.append(lmWtSites.getSitename()+"-");
                    siteName1.append(lmWtSites.getSitenumber()+"&"+lmWtSites.getSitename()+"%");
                }
                siteName.delete(siteName.length()-1, siteName.length());
                siteName1.delete(siteName1.length()-1, siteName1.length());
                classline.setSiteName(siteName.toString());
                classline.setSiteName1(siteName1.toString());
               
            }else{
                classline.setSiteName("");
                classline.setSiteName1("");
            }
            newClasslines.add(classline);
        }
        return newClasslines;
    }
}
