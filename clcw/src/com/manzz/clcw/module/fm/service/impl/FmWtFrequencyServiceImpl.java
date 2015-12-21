package com.manzz.clcw.module.fm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.FmWtFrequency;
import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.fm.dao.FmWtFrequencyDAO;
import com.manzz.clcw.module.fm.service.FmWtFrequencyService;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.clcw.module.lm.dao.LmWtClasslineDAO;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-11
 */
public class FmWtFrequencyServiceImpl extends PaginationServiceImpl<FmWtFrequency> implements FmWtFrequencyService{
	@Autowired
	private FmWtFrequencyDAO dao;
	@Autowired
    private LmWtClasslineDAO classlineDao;

    @Override
    public List<FmWtFrequencyVo> queryFrequencyVoByCondition(FmWtFrequencyVo condition) {
        List<FmWtFrequencyVo> fres = dao.queryFrequencyVoByCondition(condition);
        for (FmWtFrequencyVo fmWtFrequencyVo : fres) {
            String[] siteNumbers = fmWtFrequencyVo.getSiteList().split(",");
            List<LmWtSites> sites = classlineDao.querySiteNameBySiteNumbers(siteNumbers);
            StringBuffer siteName = new StringBuffer();
            if(sites!=null &&sites.size() != 0){
                for (LmWtSites lmWtSites : sites) {
                    siteName.append(lmWtSites.getSitename()+",");
                }
                siteName.delete(siteName.length()-1, siteName.length());
                fmWtFrequencyVo.setSitename(siteName.toString());
            }
        }
        return fres;
    }
}
