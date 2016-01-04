package com.cht.ddhb.module.sm.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cht.ddhb.domain.SmUser;
import com.cht.ddhb.module.sm.service.SmUserService;
import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.util.ValidateUtils;

/**
 * @author XT
 * @version:2015-12-22
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController {

    @Autowired
    private SmUserService smUserService;

    @Autowired
    private WxMpService wxMpService;
    
    @Autowired
    private WxMpMessageRouter wxMpMessageRouter;
    @Autowired
    private WxMpInMemoryConfigStorage mpInMemoryConfigStorage;
    @RequestMapping(value = "/index")
    public void weixinIndex(String signature, String nonce, String timestamp,String echostr, HttpServletResponse response,
        HttpServletRequest request) throws IOException, WxErrorException {

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
            response.getWriter().println("非法请求");
            return;
        }
        if (!ValidateUtils.isBlank(echostr)) {
            response.getWriter().println(echostr);
            return;
        }
        String encryptType = !ValidateUtils.isBlank(request.getParameter("encrypt_type")) ?
            "raw" :
            request.getParameter("encrypt_type");
        if ("raw".equals(encryptType) || encryptType ==null) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
            System.out.println(inMessage.toString());
            WxMpMessageHandler handler = new WxMpMessageHandler() {
                @Override public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,WxSessionManager arg3) {
                  WxMpXmlOutTextMessage m
                      = WxMpXmlOutMessage.TEXT().content("测试加密消息").fromUser(wxMessage.getToUserName())
                      .toUser(wxMessage.getFromUserName()).build();
                  return m;
                }
              };
            wxMpMessageRouter.rule()
            .async(false)
            .content("哈哈") // 拦截内容为“哈哈”的消息
            .handler(handler)
            .end();
            WxMpXmlOutTextMessage message =  (WxMpXmlOutTextMessage) wxMpMessageRouter.route(inMessage);
            response.getWriter().write(message.toXml());
            return;
        }

        if ("aes".equals(encryptType)) {
            String msgSignature = request.getParameter("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), mpInMemoryConfigStorage, timestamp, nonce, msgSignature);
            System.out.println(inMessage.toString());
            response.getWriter().print(inMessage.toString());
            // 是aes加密的消息
            return;
        }

        response.getWriter().println("不可识别的加密类型");
        return;
    }

    /**
     * 功能:查询
     * @param condition
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmUserList(@RequestBody SmUser condition) {
        return smUserService.queryByCondition(condition);
    }

    /**
     * 功能:分页查询
     * @param condition
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/pageList", method = RequestMethod.POST)
    @ResponseBody
    public Object querySmUserPageList(@RequestBody SmUser condition) {
        return smUserService.queryPaginationVO(condition);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Object doSaveSmUser(@RequestBody SmUser smUser) {
        return smUserService.doSaveUser(smUser);
    }

    /**
     * 功能:无效
     * @param id
     * @return
     */
    @RequestMapping(value = "/invalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doInvalidateSmUser(@PathVariable String id) {
        return smUserService.doInvalidate(id);
    }

    /**
     * 功能:有效
     * @param id
     * @return
     */
    @RequestMapping(value = "/revalidate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object doRevalidateSmUser(@PathVariable String id) {
        return smUserService.doRevalidate(id);
    }

    /**
     * 功能:唯一性检验
     * @param user
     * @return
     */
    @RequestMapping(value = "/uniquee", method = RequestMethod.POST)
    @ResponseBody
    public Object doRevalidateSmUser(@RequestBody SmUser user) {
        if (smUserService.queryUniquessByCondition(user)) {
            return true;
        } else {
            throw new BusinessException("唯一性检验失败！");
        }
    }
}