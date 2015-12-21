
package com.manzz.clcw.module.cm.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.module.bd.service.BdWtCarsService;
import com.manzz.clcw.module.bd.service.BdWtDriverService;
import com.manzz.clcw.module.bd.web.vo.BdWtCarsVo;
import com.manzz.clcw.module.fm.service.FmWtCharteredService;
import com.manzz.clcw.module.fm.service.FmWtFrequencyService;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.clcw.module.lm.service.LmWtClasslineService;
import com.manzz.clcw.module.lm.service.LmWtLinesService;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.util.DateUtils;
import com.manzz.framework.core.util.JacksonUtils;

/**
 * 运营统计
 * ClassName: StatisticsController <br/>
 * @author XT
 * @version 2015年9月21日
 */
@RequestMapping("/Statistics")
@Controller
public class StatisticsController {
    @Autowired
    private FmWtFrequencyService frequencyService;
    @Autowired
    private FmWtCharteredService charteredService;
    @Autowired
    private LmWtLinesService lineService;
    @Autowired
    private LmWtClasslineService classlineService;
    @Autowired
    private BdWtCarsService carService;
    @Autowired
    private BdWtDriverService driverService;
    /**
     * 功能:跳转到运营统计页面
     * @return
     */
    @RequestMapping("/Index")
    public String index(Model map){
        List<LmWtLinesVo> lines = lineService.queryLinesVoByCompany(SessionHolder.getCompanyId());
        List<LmWtClassline> classlines = classlineService.queryByCondition(new LmWtClassline());
        BdWtCarsVo car = new BdWtCarsVo();
        car.setCompany(SessionHolder.getCompanyId());
        List<BdWtCarsVo> cars = carService.queryByCarsVoByCondition(car);
        BdWtDriver condition = new BdWtDriver();
        condition.setCompany(SessionHolder.getCompanyId());
        List<BdWtDriver> drivers = driverService.queryByCondition(condition);
        map.addAttribute("lines", lines);
        map.addAttribute("classlines", classlines);
        map.addAttribute("cars", cars);
        map.addAttribute("drivers", drivers);
        map.addAttribute("driverBeans", JacksonUtils.beanToJson(drivers));
        map.addAttribute("carsBeans", JacksonUtils.beanToJson(cars));
        map.addAttribute("curDate", DateUtils.toShortDateString(new Date()));
        map.addAttribute("startCurTime", DateUtils.toFormatDateString(new Date(), "hh:MM:ss"));
        map.addAttribute("endCurTime", DateUtils.toFormatDateString(DateUtils.addHours(new Date(), 1), "hh:MM:ss"));
        return "/Statistics/Index";
    }
    @RequestMapping(value="/SearchStatistics",method=RequestMethod.POST)
    @ResponseBody
    public Object searchStatistics(Model map,FmWtFrequencyVo condition ){
        condition.setCompanyId(SessionHolder.getCompanyId());
        condition.setFrequence(false);//查询出来的数据供统计使用
        List<FmWtFrequencyVo> frequencys = frequencyService.queryFrequencyVoByCondition(condition);
        return frequencys;
    }
    
}

