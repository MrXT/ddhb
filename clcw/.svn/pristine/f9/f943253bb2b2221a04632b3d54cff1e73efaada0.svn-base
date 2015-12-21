package com.manzz.clcw.module.bd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.clcw.domain.FmWtChartered;
import com.manzz.clcw.module.bd.dao.BdWtDriverDAO;
import com.manzz.clcw.module.bd.service.BdWtDriverService;
import com.manzz.clcw.module.fm.dao.FmWtCharteredDAO;
import com.manzz.clcw.module.fm.dao.FmWtFrequencyDAO;
import com.manzz.clcw.module.fm.web.vo.FmWtCharteredVo;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-16
 */
public class BdWtDriverServiceImpl extends PaginationServiceImpl<BdWtDriver> implements BdWtDriverService{
	@Autowired
	private BdWtDriverDAO dao;
	
	@Autowired
	private FmWtCharteredDAO charteredDAO; 
	@Autowired
    private FmWtFrequencyDAO frequencyDAO;
    @Override
    public Integer doUpdateFreezz(String driverId) {
        BdWtDriver driver = new BdWtDriver(); 
        driver.setDriverId(driverId);
        driver.setFreeze("1");//冻结
        int count = dao.updateByPrimaryKeySelective(driver);
        if(count>0){
                //修改成功后，把班次中已派车的司机置为0，多个司机分别设置
                FmWtFrequencyVo condition = new FmWtFrequencyVo();
                //查处当前未发车的班次
                condition.setCompanyId(SessionHolder.getCompanyId());
                condition.setFrequence(true);//查询出来的数据供班次发布界面所调用
                List<FmWtFrequencyVo> frequencys = frequencyDAO.queryFrequencyVoByCondition(condition);
                for (FmWtFrequencyVo frequency : frequencys) {
                    if(frequency.getCharteredVo().getCharteredId() == null && frequency.getCarSDrivers() != null){
                        String carSDrivers = frequency.getCarSDrivers();//carSDrivers(1对最多3个司机id)的格式是_车牌号,driverId,driverId,driverId__车牌号,driverId,driverId,driverId_
                        String newCarSDrivers = carSDrivers.replaceAll(driverId, "0");
                        frequency.setCarSDrivers(newCarSDrivers);
                        frequencyDAO.updateByPrimaryKeySelective(frequency);
                    }
                }
        }
        return count;
    }
    public ResponseJson doSaveDriver(BdWtDriver record) {
        ResponseJson json = new ResponseJson();
        BdWtDriver old = queryByPrimaryKey(record.getDriverId());
        json.setSuccess(true);
        if (old == null) {
            BdWtDriver condition = new BdWtDriver();
            condition.setCertificatenumber(record.getCertificatenumber());
            condition.setPhone(record.getPhone());
            List<BdWtDriver> drivers = dao.queryDriverByPhoneOrCertificatenumber(condition);
            if(drivers.size()==0){
                record.setFreeze("0");//默认未冻结
                doInsert(record);
                json.setMsg("操作成功");
            }else{//如果查出来的数据为已冻结，提示
                if(drivers.get(0).getPhone().equals(record.getPhone())||drivers.get(0).getCertificatenumber().equals(record.getCertificatenumber())){
                    if(drivers.get(0).getFreeze().equals("1")){
                        json.setMsg("操作失败，拥有该手机号或者从业资格证号的司机被冻结！");
                        json.setData(drivers.get(0).getDriverId());
                        json.setSuccess(false);
                    }else{
                        json.setMsg("操作失败！手机号或者从业资格证号已经存在。");
                    }
                }
            }
        } else {
            if(old.getCertificatenumber().equals(record.getCertificatenumber())&& old.getPhone().equals(record.getPhone())){
                doUpdate(record);
                json.setMsg("操作成功");
                FmWtChartered chartered = new FmWtChartered();
                chartered.setCompany(SessionHolder.getCompanyId());
                List<FmWtCharteredVo> chartereds =  charteredDAO.queryCharteredVoByCondition(chartered);
                for (FmWtCharteredVo vo : chartereds) {
                    if(vo.getDrivername().indexOf(old.getFullname()) != -1){
                        String driverName = vo.getDrivername().replaceAll(old.getFullname(), record.getFullname());
                        vo.setDrivername(driverName);
                        charteredDAO.updateByPrimaryKeySelective(vo);
                    }
                }
            }else{
                BdWtDriver condition = new BdWtDriver();
                condition.setCertificatenumber(record.getCertificatenumber());
                condition.setPhone(record.getPhone());
                List<BdWtDriver> drivers = dao.queryDriverByPhoneOrCertificatenumber(condition);
                if(drivers.size() == 0 ){
                    doUpdate(record);
                    json.setMsg("操作成功");
                }else if(drivers.size() == 1 ){
                    if(drivers.get(0).getPhone().equals(old.getPhone())||drivers.get(0).getCertificatenumber().equals(old.getCertificatenumber())){
                        doUpdate(record);
                        json.setMsg("操作成功");
                    }else{
                        json.setMsg("操作失败！司机从业资格证号，手机号已经存在。");
                    }
                }
                else{
                    json.setMsg("操作失败！司机从业资格证号，手机号已经存在。");
                }
            }
        }
        return json;
    }
}
