
package com.manzz.gps.module.cm.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.module.bd.service.BdWtCarsService;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.gps.domain.CmWtCars;
import com.manzz.gps.module.cm.service.CmWtCarsService;

@Controller
@RequestMapping("/Monitor")
public class MonitorController {
    @Autowired
    private CmWtCarsService cmCarsService;
    @Autowired
    private BdWtCarsService bdCarsService;
    
    /**
     *跳转到监控主页
     */
    @RequestMapping("/Index")
    public String index(Model map){
        BdWtCars condition = new BdWtCars();
        condition.setCompany(SessionHolder.getCompanyId());
        condition.setFreeze("0");//查询未冻结的车辆
        List<BdWtCars> cars = bdCarsService.queryByCondition(condition);
        map.addAttribute("cars", cars);
        return "Monitor/Index";
    }
    /**
     *跳转到监控主页
     */
    @RequestMapping("/MapView")
    public String mapView(Model map){
        BdWtCars condition = new BdWtCars();
        condition.setCompany(SessionHolder.getCompanyId());
        condition.setFreeze("0");//查询未冻结的车辆
        List<BdWtCars> cars = bdCarsService.queryByCondition(condition);
        map.addAttribute("cars", cars);
        return "Monitor/MapView";
    }
    /**
     * 功能:根据条件查询相应车辆的gps数据
     * @param car
     * @return
     */
    @RequestMapping(value = "/SearchMonitor" ,method = RequestMethod.POST)
    @ResponseBody
    public Object searchMonitor(CmWtCars car){
        return cmCarsService.queryCarGpsVoByCondition(car);
    }
}

