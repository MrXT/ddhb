package com.manzz.clcw.module.bd.service;

import java.util.List;

import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.module.bd.web.vo.BdWtCarsVo;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationService;
import com.manzz.gps.domain.CmWtCars;
/**
 * 功能：TODO
 * @author XXXX
 * @version:2015-9-11
 */
public interface BdWtCarsService extends PaginationService<BdWtCars>{

    /**
     * 
     * 功能:(查询车辆带安检记录). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<BdWtCarsVo> queryByCarsVoByCondition(BdWtCarsVo condition);

    /**
     * 
     * 功能:(冻结车辆). <br/>
     *
     * @author XT
     * @param carId
     * @return
     */
    Integer doUpdateFreezz(String carId);

    /**
     * 功能:保存车辆
     * @param car
     * @return
     */
    ResponseJson doSaveCar(BdWtCars car);

    int doUpdateActivation(BdWtCars car, CmWtCars cmCar);


}