
package com.manzz.clcw.module.lm.web.controller;

import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.BdGtRegion;
import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.module.bd.service.BdGtRegionService;
import com.manzz.clcw.module.lm.service.LmWtClasslineService;
import com.manzz.clcw.module.lm.service.LmWtLinesService;
import com.manzz.clcw.module.lm.service.LmWtSitesService;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.common.SessionHolder;

/**
 * 线路管理
 * ClassName: LinesController <br/>
 * @author XT
 * @version 2015年9月20日
 */
@Controller
@RequestMapping("/Lines")
public class LinesController {
    @Autowired
    private LmWtLinesService linesService;
    @Autowired
    private BdGtRegionService regionService;
    @Autowired
    private LmWtSitesService siteService;
    @Autowired
    private LmWtClasslineService classlineService;
    
    /**
     * 功能:(跳转到线路管理页面). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping("/Index")
    public String vehicles(){
        return "Lines/Index";
    }
    
    /**
     * 功能:获取行政编码与地址
     * @param session
     * @return
     */
    @RequestMapping(value = "/GetRegion" ,method = RequestMethod.POST)
    @ResponseBody
    public Object getRegion(){
        List<BdGtRegion> regions = regionService.queryByCondition(new BdGtRegion());
        return regions;
    }
    /**
     * 功能:查询所有的线路
     * @return
     */
    @RequestMapping(value = "/GetLines" ,method = RequestMethod.POST)
    @ResponseBody
    public Object getLines(){
        LmWtLines line = new LmWtLines();
        line.setCompany(SessionHolder.getCompanyId());
        List<LmWtLinesVo> regions = linesService.queryLinesVoByCondition(line);
        return regions;
    }
    /**
     * 功能:删除线路（根据是否该线路有班次）
     * @param lineId
     * @return
     */
    @RequestMapping(value = "/DeleteLine" ,method = RequestMethod.POST)
    @ResponseBody
    public Object deleteLine(String lineId){
        return linesService.doDeleteCascadeSite(lineId);
    }
    /**
     * 功能:保存线路
     * @param line
     * @return
     */
    @RequestMapping(value = "/CreateLine" ,method = RequestMethod.POST)
    @ResponseBody
    public Object createLine(LmWtLinesVo line){
        line.setCompany(SessionHolder.getCompanyId());
        line.setDefaultValue();
        return linesService.doSaveByDepartureNameAndDepartureName(line);
    }
    /**
     * 功能:跳转到站点编辑页面
     * @param line
     * @return
     */
    @RequestMapping(value = "/ToViaSite")
    public String toViaSite(LmWtLinesVo line,Model map){
        LmWtLinesVo newline = siteService.queryEndSitesAndStartSitesByCondition(line);
        map.addAttribute("line", newline);
        return "Lines/ViaSite";
    }
    /**
     * 功能:查询线路的班线
     * @param condition
     * @return
     */
    @RequestMapping(value = "/SearchClassLine" ,method = RequestMethod.POST)
    @ResponseBody
    public Object searchClassLine(LmWtLines condition ){
        condition.setCompany(SessionHolder.getCompanyId());
        return classlineService.queryByLinesVoByCondition(condition);
    }
    /**
     * 功能:修改线路的站点
     * @param param
     * @return
     */
    @RequestMapping(value = "/UpdateLineSites" ,method = RequestMethod.POST)
    @ResponseBody
    public Object updateLineSites(String lineId,String lineName,Integer departure,Integer destination,String []ssiteNames,String []esiteNames){
        return linesService.doUpdateLineSites(lineId,lineName,departure,destination,ssiteNames,esiteNames);
    }
    @RequestMapping(value = "/AddClassLine" ,method = RequestMethod.POST)
    @ResponseBody
    public Object addClassLine(LmWtClassline condition){
        condition.setDefaultValue();
        return classlineService.doSave(condition);
    }
    @RequestMapping(value = "/DeleteClassLine" ,method = RequestMethod.POST)
    @ResponseBody
    public Object deleteClassLine(String classlineId){
        return classlineService.doDelete(classlineId);
    }
}

