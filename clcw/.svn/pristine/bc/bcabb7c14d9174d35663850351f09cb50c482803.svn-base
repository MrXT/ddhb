
package com.manzz.clcw.module.fm.web.controller;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.clcw.domain.FmWtChartered;
import com.manzz.clcw.domain.FmWtFrequency;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.module.bd.service.BdWtCarsService;
import com.manzz.clcw.module.bd.service.BdWtDriverService;
import com.manzz.clcw.module.bd.web.vo.BdWtCarsVo;
import com.manzz.clcw.module.fm.service.FmWtCharteredService;
import com.manzz.clcw.module.fm.service.FmWtFrequencyService;
import com.manzz.clcw.module.fm.service.FmWtTicketsService;
import com.manzz.clcw.module.fm.web.vo.FmWtCharteredVo;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.clcw.module.lm.service.LmWtClasslineService;
import com.manzz.clcw.module.lm.service.LmWtLinesService;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.util.DateUtils;
import com.manzz.framework.core.util.JacksonUtils;

/**
 * 班线的处理
 * ClassName: FrequencyController <br/>
 * @author XT
 * @version 2015年9月16日
 */
@Controller
@RequestMapping("/Frequency")
public class FrequencyController {
    @Autowired
    private FmWtFrequencyService frequencyService;
    @Autowired
    private FmWtCharteredService charteredService;
    @Autowired
    private BdWtCarsService carsService;
    @Autowired
    private BdWtDriverService driverService;
    @Autowired
    private LmWtClasslineService classlineService;
    @Autowired
    private FmWtTicketsService ticketsService;
    @Autowired
    private LmWtLinesService lineService;
    /**
     * 功能:(跳转到班次发布主页). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping("/Index")
    public String index(Model map){
        List<LmWtLinesVo> lines = lineService.queryLinesVoByCompany(SessionHolder.getCompanyId());
        BdWtCarsVo condition = new BdWtCarsVo();
        condition.setCompany(SessionHolder.getCompanyId());
        condition.setFreeze("0");//查询未冻结的车辆
        condition.setCheckstatus(Constants.CAR_PASS);//查询安检通过的车辆
        List<BdWtCarsVo> cars = carsService.queryByCarsVoByCondition(condition);
        map.addAttribute("lines", lines);
        map.addAttribute("curDate", DateUtils.toShortDateString(new Date()));
        map.addAttribute("cars", JacksonUtils.beanToJson(cars));
        return "Frequency/Index";
    }
    /**
     * 功能:(查询某公司的包车单). <br/>
     * @author XT
     * @param session
     * @return
     */
    @RequestMapping(value = "/WebSearchChartered" ,method = RequestMethod.POST)
    @ResponseBody
    public Object webSearchChartered(){
        FmWtChartered condition = new FmWtChartered();
        condition.setCompany(SessionHolder.getCompanyId());
        List<FmWtCharteredVo> chartereds = charteredService.queryCharteredVoByCondition(condition);
        return chartereds;
    }
    /**
     * 功能:(新增包车单). <br/>
     * @author XT
     * @param session
     * @return
     */
    @RequestMapping(value = "/CreateChartered" ,method = RequestMethod.POST)
    @ResponseBody
    public Object createChartered(FmWtCharteredVo chartered){
        chartered.setCompany(SessionHolder.getCompanyId());
        chartered.setReleasedatetime(new Date());//发布时间
        chartered.setOperId(SessionHolder.getCurrentUser().getUserId());
        int code = charteredService.doInsertCharered(chartered);
        return code;
    }
    @RequestMapping(value = "/EditChartered" ,method = RequestMethod.POST)
    @ResponseBody
    public Object editChartered(FmWtChartered chartered){
        chartered.setOperId(SessionHolder.getCurrentUser().getUserId());
        int code = charteredService.doUpdate(chartered);
        return code;
    }
    @RequestMapping(value = "/DeleteChartered" ,method = RequestMethod.POST)
    @ResponseBody
    public Object deleteChartered(Integer charteredId){
        int code = charteredService.doDelete(charteredId);
        return code;
    }
    /**
     * 功能:(查询未冻结的车辆). <br/>
     * @author XT
     * @param session
     * @return
     */
    @RequestMapping(value = "/SearchCars" ,method = RequestMethod.POST)
    @ResponseBody
    public Object searchCars(BdWtCarsVo condition){
        condition.setCompany(SessionHolder.getCompanyId());
        condition.setFreeze("0");//查询未冻结的车辆
        List<BdWtCarsVo> cars = carsService.queryByCarsVoByCondition(condition);
        return cars;
    }
    /**
     * 功能:(查询未冻结的司机). <br/>
     * @author XT
     * @param session
     * @return
     */
    @RequestMapping(value = "/SearchDrivers" ,method = RequestMethod.POST)
    @ResponseBody
    public Object searchDrivers(){
        BdWtDriver condition = new BdWtDriver();
        condition.setCompany(SessionHolder.getCompanyId());
        condition.setFreeze("0");//查询未冻结的司机
        List<BdWtDriver> drivers = driverService.queryByCondition(condition);
        return drivers;
    }
    /**
     * 功能:(查询相应条件下的班次). <br/>
     * @author XT
     * @param condition
     * @return
     */
    @RequestMapping(value = "/GetFrequency" ,method = RequestMethod.POST)
    @ResponseBody
    public Object getFrequency(FmWtFrequencyVo condition ){
        condition.setCompanyId(SessionHolder.getCompanyId());
        condition.setFrequence(true);//查询出来的数据供班次发布界面所调用
        List<FmWtFrequencyVo> frequencys = frequencyService.queryFrequencyVoByCondition(condition);
        return frequencys;
    }
    /**
     * 功能:(改变班次状态). <br/>
     * @author XT
     * @param condition
     * @return
     */
    @RequestMapping(value = "/ChangeFrequencyStatus" ,method = RequestMethod.POST)
    @ResponseBody
    public Object changeFrequencyStatus(FmWtFrequency condition ){
        return frequencyService.doUpdate(condition);
    }
    /**
     * 功能:(根据出发地与目的地,公司查询班线). <br/>
     * @author XT
     * @param condition
     * @return
     */
    @RequestMapping(value = "/SearchClassLineByCompany" ,method = RequestMethod.POST)
    @ResponseBody
    public Object searchClassLineByCompany(LmWtLines condition ){
        condition.setCompany(SessionHolder.getCompanyId());
        return classlineService.queryClassLineByCompany(condition);
    }
    /**
     * 功能:增加班次信息)
     * @author XT
     * @param condition
     * @return
     */
    @RequestMapping(value = "/ReleaseFrequency" ,method = RequestMethod.POST)
    @ResponseBody
    public Object releaseFrequency(FmWtFrequency condition ){
        condition.setDefaultValue();
        return frequencyService.doSave(condition);
    }
    /**
     * 功能:显示售票详情
     * @param frequencyId
     * @return
     */
    @RequestMapping(value = "/ShowTickets" ,method = RequestMethod.POST)
    @ResponseBody
    public Object showTickets(String frequencyId){
        return ticketsService.queryTicketsVo(frequencyId);
    }
    /**
     * 功能: 为班次分配车辆
     * @param chartered
     * @return
     */
    @RequestMapping(value = "/assignCar" ,method = RequestMethod.POST)
    @ResponseBody
    public Object assignCar(FmWtFrequency frequency){
        return frequencyService.doUpdate(frequency);
    }
    /**
     * 功能: 查询班次的carsDrivers
     * @param chartered
     * @return
     */
    @RequestMapping(value = "/getCarsDrivers" ,method = RequestMethod.POST)
    @ResponseBody
    public Object getCarsDrivers(String frequencyId){
        return frequencyService.queryByPrimaryKey(frequencyId).getCarSDrivers();
    }
    
}

