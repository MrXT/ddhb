package com.cht.ddhb.module.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.common.util.ValidateAndThrowUtil;
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
import com.cht.framework.core.util.CommonUtils;
import com.cht.framework.core.util.MD5;

/**
 * @author XT
 * @version:2015-12-22
 */
public class SmUserServiceImpl extends PaginationServiceImpl<SmUser> implements SmUserService {

    @Autowired
    private SmUserDAO dao;

    @Autowired
    private SmResDAO resDAO;

    @Autowired
    private CmAreaDAO areaDAO;

    @Autowired
    private CmShopDAO shopDAO;

    @Override
    public SmUserVo queryUserVoByUsername(String username) {
        ValidateAndThrowUtil.isBlank(username);
        SmUserVo userVo = dao.queryUserByUsername(username);
        if (userVo != null) {
            List<SmRes> reses = null;
            // 规则判定用户是不是超级管理员，就是看他的role_id是不是defalut.superadmin.roleId
            if (userVo.getRoleId().equals(CommonUtils.readResource("defalut.superadmin.roleId"))) {
                reses = resDAO.queryPagedList(new SmRes());
            } else {
                reses = resDAO.queryResByRoleId(userVo.getRoleId());
            }
            userVo.setReses(reses);
            // 查询与userId对应的区域代理或者专卖店
            CmArea area = new CmArea();
            area.setUserId(userVo.getUserId());
            CmShop shop = new CmShop();
            shop.setUserId(userVo.getUserId());
            List<CmArea> areas = areaDAO.queryPagedList(area);
            List<CmShop> shops = shopDAO.queryPagedList(shop);
            if (areas.size() == 1) {
                userVo.setArea(areas.get(0));
            }
            if (shops.size() == 1) {
                userVo.setShop(shops.get(0));
            }
        }
        return userVo;
    }

    @Override
    public Boolean queryUniquessByCondition(SmUser smUser) {
        List<SmUser> users = dao.queryUniquessByCondition(smUser);
        if (smUser.getUserId() == null) {
            if (users.size() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (users.size() == 0) {
                return true;
            } else if (users.size() == 1 && users.get(0).getUserId().equals(smUser.getUserId())) {
                return true;
            } else {
                return false;
            }
        }
    }
    @Override
    public Integer doSaveUser(SmUser record) {
        if (record.getUserId() == null) {
            // 验证姓名,登录名,手机,支付宝邮箱帐号
            if (!ValidateAndThrowUtil.isBlank(record.getUsername(), record.getName(), record.getRoleId())
                && ValidateAndThrowUtil.isMobileNo(record.getTelephone()) && ValidateAndThrowUtil.isEmailFormat(record.getAlipayEmail())) {
                String password = MD5.getStr2Digest(CommonUtils.readResource("default.user.password"));
                record.setPassword(password);
            }
        } else {
            // 驗證傳入的手機號碼或者邮箱格式是否正確
            if (record.getTelephone() != null) {
                ValidateAndThrowUtil.isMobileNo(record.getTelephone());
            }
            if (record.getAlipayEmail() != null) {
                ValidateAndThrowUtil.isEmailFormat(record.getAlipayEmail());
            }
        }
        if (!queryUniquessByCondition(record)) {
            throw new BusinessException("字段唯一性检验失败!");
        }
        return super.doSave(record);
    }
}
