package com.manzz.gps.module.cm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.gps.domain.CmWtCars;
import com.manzz.gps.module.cm.dao.CmWtCarsDAO;
import com.manzz.gps.module.cm.service.CmWtCarsService;
import com.manzz.gps.module.cm.web.vo.CarGpsVo;
import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.module.bd.dao.BdWtCarsDAO;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-21
 */
public class CmWtCarsServiceImpl extends PaginationServiceImpl<CmWtCars>  implements CmWtCarsService {
	@Autowired
	private CmWtCarsDAO dao;
	@Autowired
	private BdWtCarsDAO carDao;

    @Override
    public List<CarGpsVo> queryCarGpsVoByCondition(CmWtCars car) {
        List<BdWtCars> cars = new ArrayList<BdWtCars>();
        if(car.getCarId()==null){
            BdWtCars condition = new BdWtCars();
            condition.setCompany(SessionHolder.getCompanyId());
            condition.setFreeze("0");//查询未冻结的车辆
            cars = carDao.queryPagedList(condition);
        }else{
            BdWtCars condition = new BdWtCars();
            condition.setCarId(car.getCarId());
            cars.add(condition);
        }
        return dao.queryCarGpsVoByCondition(cars);
    }
}
