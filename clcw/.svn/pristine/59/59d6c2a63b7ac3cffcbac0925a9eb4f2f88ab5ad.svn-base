package com.manzz.clcw.module.lm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.BdGtRegion;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.bd.dao.BdGtRegionDAO;
import com.manzz.clcw.module.lm.dao.LmWtClasslineDAO;
import com.manzz.clcw.module.lm.dao.LmWtLinesDAO;
import com.manzz.clcw.module.lm.dao.LmWtSitesDAO;
import com.manzz.clcw.module.lm.service.LmWtLinesService;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationServiceImpl;

/**
 * @author XT
 * @version:2015-9-11
 */
public class LmWtLinesServiceImpl extends PaginationServiceImpl<LmWtLines> implements LmWtLinesService {

    @Autowired
    private LmWtLinesDAO dao;

    @Autowired
    private LmWtClasslineDAO classLinedao;

    @Autowired
    private LmWtSitesDAO siteDAO;
    @Autowired
    private BdGtRegionDAO regionDAO;

    @Override
    public List<LmWtLinesVo> queryLinesVoByCondition(LmWtLines line) {

        return dao.queryLinesVoByCondition(line);
    }

    @Override
    public int doUpdateLineSites(String lineId, String lineName, Integer departure, Integer destination, String[] ssiteNames, String[] esiteNames) {
        LmWtLines line = new LmWtLines();
        line.setLineId(lineId);
//        // 获取该线路下的班线
//        List<LmWtClasslineVo> classlineVos = classLinedao.queryClassLineByCompany(line);
//        for (LmWtClasslineVo classline : classlineVos) {
//            String[] siteNumbers = classline.getSiteList().split(",");
//            List<LmWtSites> sites = classLinedao.querySiteNameBySiteNumbers(siteNumbers);
//            classline.setSites(sites);
//        }
//        // 对班线的siteList字段赋值为“”
//        for (LmWtClasslineVo classlineVo : classlineVos) {
//            classlineVo.setSiteList("");
//        }
        // 获取最大的siteNumber
        int maxSiteNumber = dao.queryMaxSiteNumber(lineId);
        List<LmWtSites> sites = new ArrayList<LmWtSites>();
        if(ssiteNames != null){
            for (String ssiteName : ssiteNames) {
                LmWtSites wtSite = new LmWtSites();
                wtSite.setLineId(lineId);
                wtSite.setRegionCode(departure);
                wtSite.setSitename(ssiteName);
                wtSite.setLinename(lineName);
                wtSite.setLinecode(String.valueOf(departure) + String.valueOf(destination));
                wtSite.setSitenumber(++maxSiteNumber);
                sites.add(wtSite);
    //            for (LmWtClasslineVo classlineVo : classlineVos) {
    //                String siteList = classlineVo.getSiteList();
    //                for (LmWtSites lmWtSites : classlineVo.getSites()) {
    //                    if (lmWtSites.getSitename().equals(ssiteName) && lmWtSites.getRegionCode().intValue() == departure.intValue()) {
    //                        siteList += maxSiteNumber + ",";
    //                        break;
    //                    }
    //                }
    //                classlineVo.setSiteList(siteList);
    //            }
            }
        }
        if(esiteNames !=null){
            for (String esiteName : esiteNames) {
                LmWtSites wtSite = new LmWtSites();
                wtSite.setLineId(lineId);
                wtSite.setRegionCode(destination);
                wtSite.setSitename(esiteName);
                wtSite.setLinename(lineName);
                wtSite.setLinecode(String.valueOf(departure) + String.valueOf(destination));
                wtSite.setSitenumber(++maxSiteNumber);
                sites.add(wtSite);
    //            for (LmWtClasslineVo classlineVo : classlineVos) {
    //                String siteList = classlineVo.getSiteList();
    //                for (LmWtSites lmWtSites : classlineVo.getSites()) {
    //                    if (lmWtSites.getSitename().equals(esiteName) && lmWtSites.getRegionCode().intValue() == destination.intValue()) {
    //                        siteList += maxSiteNumber + ",";
    //                        break;
    //                    }
    //                }
    //                classlineVo.setSiteList(siteList);
    //            }
            }
        }
        // 为了让历史数据展示，就不删除之前的站点，改为修改站点的line_Id为0(站点失效)；
        //dao.deleteSiteByLineId(lineId);
        siteDAO.updateSiteInValid(lineId);
        if(sites.size()==0){
            return 0;
        }
        if (dao.insertSitesByLine(sites) > 0) {
//            for (LmWtClasslineVo classlineVo : classlineVos) {
//                boolean haveStart = false;
//                boolean haveEnd = false;
//                classlineVo.setSiteList(classlineVo.getSiteList().substring(0, classlineVo.getSiteList().length() - 1));
//                String[] siteNumbers = classlineVo.getSiteList().split(",");
//                List<LmWtSites> wtsites = classLinedao.querySiteNameBySiteNumbers(siteNumbers);
//                for (LmWtSites lmWtSites : wtsites) {
//                    if (lmWtSites.getRegionCode().intValue() == departure.intValue()) {
//                        haveStart = true;
//                    }
//                    if (lmWtSites.getRegionCode().intValue() == destination.intValue()) {
//                        haveEnd = true;
//                    }
//                }
//                if (!(haveEnd && haveStart)) {
//                    throw new BusinessException("-1", "请确定站点删除或者修改后，班线至少有一个起点城市的站点与一个终点城市的站点！");
//                } else {
//                    LmWtClassline classline = new LmWtClassline();
//                    classline.setClasslineId(classlineVo.getClasslineId());
//                    classline.setLineId(classlineVo.getLineId());
//                    classline.setSiteList(classlineVo.getSiteList());
//                    classline.setClasslineName((classlineVo.getClasslineName()));
//                    classLinedao.updateByPrimaryKeySelective(classline);
//                }
//            }
//            return classlineVos.size();
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int doDeleteCascadeSite(String lineId) {
        if (doDelete(lineId) > 0) {
            return dao.deleteSiteByLineId(lineId) + dao.deleteClasslineByLineId(lineId);
        } else {
            return 0;
        }
    }

    @Override
    public List<LmWtLinesVo> queryLinesVoByCompany(String companyId) {

        return dao.queryLinesVoByCompany(companyId);
    }

    /**
     * region表意义变了，变成线路的目的地址与起始地址的表
     * @see com.manzz.clcw.module.lm.service.LmWtLinesService#doSaveByDepartureNameAndDepartureName(com.manzz.clcw.domain.LmWtLines, java.lang.String, java.lang.String)
     */
    @Override
    public ResponseJson doSaveByDepartureNameAndDepartureName(LmWtLinesVo line) {
        ResponseJson json = new ResponseJson();
        List<BdGtRegion> regions = regionDAO.queryByRegionName(line);
        for (BdGtRegion bdGtRegion : regions) {
            if(bdGtRegion.getRegionRegionname().equals(line.getDeparturename())){
                line.setDeparture(bdGtRegion.getRegionCode());
            }else if(bdGtRegion.getRegionRegionname().equals(line.getDestinationname())){
                line.setDestination(bdGtRegion.getRegionCode());
            }
        }
        if(line.getDeparture() == null){
            BdGtRegion bdGtRegion = new BdGtRegion();
            bdGtRegion.setRegionRegionname(line.getDeparturename());
            regionDAO.insert(bdGtRegion);
            line.setDeparture(bdGtRegion.getRegionCode());
        }
        if(line.getDestination() == null){
            BdGtRegion bdGtRegion = new BdGtRegion();
            bdGtRegion.setRegionRegionname(line.getDestinationname());
            regionDAO.insert(bdGtRegion);
            line.setDestination(bdGtRegion.getRegionCode());
        }
        if(dao.queryPagedList(line).size() > 0){
            json.setMsg("不能添加重复的线路！");
            json.setSuccess(false);
        }else{
            dao.insert(line);
            json.setMsg("操作成功！");
            json.setSuccess(true);
          
        }
        return json;
    }


}
