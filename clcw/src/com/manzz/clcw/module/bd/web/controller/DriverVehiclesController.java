
package com.manzz.clcw.module.bd.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.clcw.module.bd.service.BdWtCarsService;
import com.manzz.clcw.module.bd.service.BdWtDriverService;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.gps.domain.CmWtCars;
/**
 * 驾驶员车辆管理控制器
 * ClassName: DriverVehiclesController <br/>
 * @author XT
 * @version 2015年9月17日
 */
@Controller
public class DriverVehiclesController {

    @Autowired
    private BdWtDriverService driverService;
    @Autowired
    private BdWtCarsService carsService;
    /**
     * 功能:(跳转到车辆管理页面). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping("/Management/Vehicles")
    public String vehicles(Model map){
        return "/Management/Vehicles";
    }
    /**
     * 功能:(跳转到司机管理页面). <br/>
     * @author XT
     * @param map
     * @return
     */
    @RequestMapping("/Management/Drivers")
    public String index(Model map){
        return "/Management/Drivers";
    }
    /**
     * 功能:(保存车辆的信息). <br/>
     * @author XT
     * @param map
     * @param car
     * @return
     */
    @RequestMapping(value = "/Management/saveCar",method = RequestMethod.POST)
    @ResponseBody
    public Object saveCar(Model map,BdWtCars car){
        car.setCompany(SessionHolder.getCompanyId());
        car.setFreeze("0");//默认为未冻结
        car.setDefaultValue();
        return carsService.doSaveCar(car);
    }
    /**
     * 功能:(冻结车辆). <br/>
     * @author XT
     * @param map
     * @param carId
     * @return
     */
    @RequestMapping(value = "/Management/DeleteCar",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteCar(Model map,String carId){
        return carsService.doUpdateFreezz(carId);
    }
    /**
     * 功能:(保存司机的信息). <br/>
     * @author XT
     * @param map
     * @param driver
     * @return
     */
    @RequestMapping(value = "/Management/saveDriver",method = RequestMethod.POST)
    @ResponseBody
    public Object saveDriver(Model map,BdWtDriver driver){
        driver.setCompany(SessionHolder.getCompanyId());
        driver.setDefaultValue();
        return driverService.doSaveDriver(driver);
    }
    /**
     * 功能:(冻结司机). <br/>
     * @author XT
     * @param map
     * @param driverId
     * @return
     */
    @RequestMapping(value ="/Management/DeleteDriver",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteDriver(Model map,String driverId){
        return driverService.doUpdateFreezz(driverId);
    }
    /**
     * 功能:激活司机
     * @param map
     * @param driverId
     * @return
     */
    @RequestMapping(value ="/Management/Activation",method = RequestMethod.POST)
    @ResponseBody
    public Object activation(Model map,BdWtDriver driver,BdWtCars car,CmWtCars cmCar){
        if(driver.getDriverId() != null){
            return driverService.doUpdate(driver);
        }else{
            return carsService.doUpdateActivation(car,cmCar);
        }
    }
}

