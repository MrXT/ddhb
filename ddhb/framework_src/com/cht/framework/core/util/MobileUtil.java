package com.cht.framework.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 发送短信工具类
 * @author WJK
 * @version 2015-08
 */
public class MobileUtil {

    /** 短信接收移动接口url */
    private static final String MOBILE_NOTE_CMCC_URL = "http://sms.zy28.com:8888/sms.aspx?action=send&userid=308&account=cdmz&password=123456";

    /** 短信接收电信接口url */
    private static final String MOBILE_NOTE_TELECOM_ULICOM_URL = "http://mb345.com:999/ws/BatchSend.aspx?CorpID=LKSDK0003850&Pwd=jkwqm814@";
    //1349属于电信,134[0-8]属于移动,176属于联通新业务号
    /** 电信  */
    private static final String[] TELECOM_PREFIX_ARRAY = { "133","1349", "153", "180", "181", "189"};
    /** 联通 */
    private static final String[] UNICOM_PREFIX_ARRAY = { "130", "131", "132", "152","155","156","176", "185", "186" };
    /** 移动  */
    private static final String[] CMCC_PREFIX_ARRAY = { "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159","182", "187", "188" };

    public static enum MobileServiceProvider {
        /** 电信 */
        TELECOM,
        /** 联通 */
        UNICOM,
        /** 移动 */
        CMCC,
        /** 其他 */
        OTHER
    }

    public static enum Result {
        /** 格式错误 */
        FORMAT_ERROR,
        /** 响应正常 */
        RESPONSE_OK,
        /** 响应错误 */
        RESPONSE_ERROR
    }

    public static Result send(String mobile, String content) {
        if (isMobile(mobile)) {
            MobileServiceProvider provider = getServiceProvider(mobile);
            switch (provider) {
            // 全发电信、联通
            // case TELECOM:{
            // return sendToTELECOM(mobile, content);
            // }
            // case UNICOM:{
            // return sendToUNICOM(mobile, content);
            // }
            // case CMCC:{
            // return sendToCMCC(mobile, content);
            // }
                default: {
                    return sendToTELECOM(mobile, content);

                }
            }
        } else {
            return Result.FORMAT_ERROR;
        }
    }

    public static Result sendToCMCC(String mobile, String content) {
        String url = CommonUtils.assemblyURLQuestionMark(MOBILE_NOTE_CMCC_URL) + CommonUtils.assemblyURLParams("mobile", mobile)
            + CommonUtils.assemblyURLParams("content", content);

        try {
            String response = HttpClientUtils.doHttpGet(url);
            String status = XMLUtils.getText(response, "returnsms/returnstatus");
            String msg = XMLUtils.getText(response, "returnsms/message");
            LogUtil.DEBUG("parsed status:" + status + ", message:" + msg);
            // 短信接口传送成功
            if (StringUtils.isNotEmpty(status) && status.trim().equalsIgnoreCase("success")) {
                return Result.RESPONSE_OK;
            } else {
                LogUtil.ERROR(String.format("短信接口【CMCC】异常，手机号：%s, 内容：%s, 返回：%s", mobile, content, response));
            }
        } catch (Exception e) {
            LogUtil.ERROR("短信接口【CMCC】异常：", e.getMessage());
        }
        // 短信接口异常信息
        return Result.RESPONSE_ERROR;
    }

    public static Result sendToTELECOM(String mobile, String content) {
        try {
            content = URLEncoder.encode(content.replaceAll("<br/>", " "), "GBK");//转码
            String url = CommonUtils.assemblyURLQuestionMark(MOBILE_NOTE_TELECOM_ULICOM_URL) + CommonUtils.assemblyURLParams("Mobile", mobile)
                + CommonUtils.assemblyURLParams("Content", content);
            String response = HttpClientUtils.doHttpGet(url);
            Integer pRes = Integer.parseInt(response);
            // 短信接口传送成功
            if (pRes >= 0) {
                return Result.RESPONSE_OK;
            } else {
                LogUtil.ERROR(String.format("短信接口【TELECOM】异常，手机号：%s, 内容：%s, 返回：%s", mobile, content, response));
            }
        } catch (Exception e) {
            LogUtil.ERROR("短信接口【TELECOM】异常，", e.getMessage());
        }
        // 短信接口异常信息
        return Result.RESPONSE_ERROR;
    }

    public static Result sendToUNICOM(String mobile, String content) {
        return sendToTELECOM(mobile, content);
    }

    /**
     * 手机号验证
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        boolean b = false;
        if (StringUtils.isNotEmpty(str)) {
            Pattern p = null;
            Matcher m = null;
            p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
            m = p.matcher(str);
            b = m.matches();
        }
        return b;
    }

    /**
     * 获取手机运营商
     * @param mobile
     * @return
     */
    public static MobileServiceProvider getServiceProvider(String mobile) {
        if(mobile.trim().startsWith("1349")){//唯一特殊号段
            return MobileServiceProvider.TELECOM;
        }
        String prefix = mobile.trim().substring(0, 3);
        if (Arrays.asList(TELECOM_PREFIX_ARRAY).contains(prefix)) {
            return MobileServiceProvider.TELECOM;
        } else if (Arrays.asList(UNICOM_PREFIX_ARRAY).contains(prefix)) {
            return MobileServiceProvider.UNICOM;
        } else if (Arrays.asList(CMCC_PREFIX_ARRAY).contains(prefix)) {
            return MobileServiceProvider.CMCC;
        } else {
            return MobileServiceProvider.OTHER;
        }
    }

    public static void main(String[] arg) throws UnsupportedEncodingException {
        Random random = new Random();
        String vc = String.format("%06d", random.nextInt(10000));
        String msg = vc + "(动态验证码),请在2分钟内填写";
        MobileUtil.sendToCMCC("18200390083", msg);
    }
}