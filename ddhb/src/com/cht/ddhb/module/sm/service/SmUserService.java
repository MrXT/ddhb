package com.cht.ddhb.module.sm.service;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.SmUser;
import com.cht.framework.core.service.PaginationService;

/**
 * @author XT
 * @version:2015-12-22
 */
public interface SmUserService extends PaginationService<SmUser> {

    /**
     * 功能：通过用户名级联查询用户信息
     * @param username
     * @return
     */
    SmUserVo queryUserVoByUsername(String username);

    /**
     * 功能:功能:查询手机,支付宝帐号,姓名.用户名的唯一性
     * @param smUser
     * @return
     */
    Boolean queryUniquessByCondition(SmUser smUser);

    Integer doSaveUser(SmUser smUser);

}