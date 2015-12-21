package com.manzz.clcw.module.bd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.module.bd.dao.BdWtCarsDAO;
import com.manzz.clcw.module.bd.service.BdWtCarsService;
import com.manzz.clcw.module.bd.web.vo.BdWtCarsVo;
import com.manzz.clcw.module.fm.dao.FmWtFrequencyDAO;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationServiceImpl;
import com.manzz.gps.domain.CmWtCars;
import com.manzz.gps.module.cm.dao.CmWtCarsDAO;

/**
 * @author XT
 * @version:2015-9-11
 */
public class BdWtCarsServiceImpl extends PaginationServiceImpl<BdWtCars> implements BdWtCarsService {

    @Autowired
    private BdWtCarsDAO dao;

    @Autowired
    private CmWtCarsDAO carDAO;

    @Autowired
    private FmWtFrequencyDAO frequencyDAO;

    @Override
    public List<BdWtCarsVo> queryByCarsVoByCondition(BdWtCarsVo condition) {

        return dao.queryByCarsVoByCondition(condition);
    }

    @Override
    public Integer doUpdateFreezz(String carId) {
        BdWtCars car = new BdWtCars();
        car.setCarId(carId);
        car.setFreeze("1");// 冻结
        if (dao.updateByPrimaryKeySelective(car) > 0) {
            // 取出当前车辆信息
            car = dao.selectByPrimaryKey(carId);
            // 修改成功后，把班次中已派车的车牌号置为0
            FmWtFrequencyVo condition = new FmWtFrequencyVo();
            // 查处当前未发车的班次
            condition.setCompanyId(SessionHolder.getCompanyId());
            condition.setFrequence(true);// 查询出来的数据供班次发布界面所调用
            List<FmWtFrequencyVo> frequencys = frequencyDAO.queryFrequencyVoByCondition(condition);
            for (FmWtFrequencyVo frequency : frequencys) {
                if (frequency.getCharteredVo().getCharteredId() != null) {
                    String carSDrivers = frequency.getCarSDrivers();// carSDrivers(1对最多3个司机id)的格式是_车牌号,driverId,driverId,driverId__车牌号,driverId,driverId,driverId_
                    String newCarSDrivers = carSDrivers.replaceAll(car.getLicenseplate(), "0");
                    frequency.setCarSDrivers(newCarSDrivers);
                    frequencyDAO.updateByPrimaryKeySelective(frequency);
                }
            }
        }
        CmWtCars cmcar = new CmWtCars();
        cmcar.setCarId(carId);
        cmcar.setFreeze("1");// 冻结
        return carDAO.updateByPrimaryKeySelective(cmcar);
    }

    @Override
    public ResponseJson doSaveCar(BdWtCars record) {
        ResponseJson json = new ResponseJson();
        BdWtCars old = queryByPrimaryKey(record.getCarId());
        json.setSuccess(true);
        if (old == null) {
            BdWtCars newCar = new BdWtCars();
            newCar.setLicenseplate(record.getLicenseplate());// 根据车牌号来查询。
            List<BdWtCars> drivers = queryByCondition(newCar);
            if (drivers.size() == 0) {
                record.setFreeze("0");// 默认未冻结
                record.setLicenseplatecolor("蓝色");
                if (doInsert(record) > 0) {
                    CmWtCars cmWtCar = new CmWtCars();
                    cmWtCar.setCarId(record.getCarId());
                    cmWtCar.setLicenseplate(record.getLicenseplate());
                    cmWtCar.setFreeze("0");
                    carDAO.insert(cmWtCar);
                    json.setMsg("操作成功！");
                } else {
                    json.setMsg("操作失败！");
                }
            } else {// 如果查出来的数据为已冻结，提示
                if (drivers.get(0).getFreeze().equals("1")) {//
                    json.setMsg("操作失败！已有该车辆，该车辆已被冻结");
                    json.setData(drivers.get(0).getCarId());
                    json.setSuccess(false);
                } else {
                    json.setMsg("操作失败！已有该车辆。");
                }
            }
        } else {
            if (doUpdate(record) > 0) {
                CmWtCars cmWtCar = new CmWtCars();
                cmWtCar.setCarId(record.getCarId());
                cmWtCar.setLicenseplate(record.getLicenseplate());
                carDAO.updateByPrimaryKeySelective(cmWtCar);
                json.setMsg("操作成功！");
            } else {
                json.setMsg("操作失败！");
            }

        }
        return json;

    }

    @Override
    public int doUpdateActivation(BdWtCars car, CmWtCars cmCar) {
        return dao.updateByPrimaryKeySelective(car) + carDAO.updateByPrimaryKeySelective(cmCar);
    }
}
