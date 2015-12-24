package com.cht.ddhb.module.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.CmArea;
import com.cht.ddhb.domain.CmShop;
import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.domain.SmUser;
import com.cht.ddhb.module.cm.dao.CmAreaDAO;
import com.cht.ddhb.module.cm.dao.CmShopDAO;
import com.cht.ddhb.module.sm.dao.SmResDAO;
import com.cht.ddhb.module.sm.dao.SmUserDAO;
import com.cht.ddhb.module.sm.service.SmUserService;
import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-12-22
 */
public class SmUserServiceImpl extends PaginationServiceImpl<SmUser> implements SmUserService{
	@Autowired
	private SmUserDAO dao;
    @Autowired
    private SmResDAO  resDAO;
    @Autowired
    private CmAreaDAO  areaDAO;
    @Autowired
    private CmShopDAO  shopDAO;

	@Override
	public SmUserVo queryUserVoByUsername(String username) {
		if(username == null) 
            throw new BusinessException("用户账号不能为空");
		SmUserVo userVo = dao.queryUserByUsername(username);
		if(userVo != null){
			List<SmRes> reses = null;
			//规则判定用户是不是超级管理员，就是看他的role_id是不是0
			if(userVo.getRoleId().equals("0")){
				reses = resDAO.queryPagedList(new SmRes());
			}else{
				reses = resDAO.queryResByRoleId(userVo.getRoleId());
			}
			userVo.setReses(reses);
			//查询与userId对应的区域代理或者专卖店
			CmArea area = new CmArea();
			area.setUserId(userVo.getUserId());
			CmShop shop = new CmShop();
			shop.setUserId(userVo.getUserId());
			List<CmArea> areas = areaDAO.queryPagedList(area);
			List<CmShop> shops = shopDAO.queryPagedList(shop);
			if(areas.size() == 1){
			    userVo.setArea(areas.get(0));
			}
			if(shops.size() == 1){
			    userVo.setShop(shops.get(0));
			}
		}
		return userVo;
	}
}
