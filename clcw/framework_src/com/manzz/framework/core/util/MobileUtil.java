package com.manzz.framework.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.rmi.RemoteException;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.manzz.clcw.common.cmcc.MasServiceSoapProxy;
import com.manzz.clcw.common.cmcc.SendSmsResult;

/**
 * 发送短信工具类
 * @author WJK
 * @version 2015-10
 */
public class MobileUtil {

    /** 短信接收移动接口url */
//    private static final String MOBILE_NOTE_CMCC_URL = "http://sms.zy28.com:8888/sms.aspx?action=send&userid=308&account=cdmz&password=123456";
    /** 短信接收电信接口url */
    private static final String MOBILE_NOTE_TELECOM_ULICOM_URL = "http://mb345.com:999/ws/BatchSend.aspx?CorpID=LKSDK0003850&Pwd=jkwqm814@";
    /** 电话号码校验规则 */
    private static final String MOBILE_REGEX = "^1[34578][0-9]{9}$";
    /** 电信号段  133, 1349, 153, 170[012],177,18[019] */
    private static final String TELECOM_REGEX = "^1((33|53|77|8[019])[0-9]|349|70[012])[0-9]{7}$";
    /** 联通号段  13[012],145,15[56],1709,176,18[56]*/
    private static final String UNICOM_REGEX = "^1((3[0-2]|45|5[56]|76|8[56])[0-9]|709)[0-9]{7}$";
    /** 移动号段  134[0-8],13[5-9],14[789],15[012789],1705,178,18[234],187,188 */
    private static final String CMCC_REGEX = "^1(34[0-8]|705|(3[5-9]|4[789]|5[012789]|78|8[23478])[0-9])[0-9]{7}$";
    
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
                case TELECOM: {
                    return sendToTELECOM(mobile, content);
                }
                case UNICOM: {
                    return sendToUNICOM(mobile, content);
                }
                case CMCC: {
                    return sendToCMCC(mobile, content);
                }
                default: {
                    return sendToTELECOM(mobile, content);
                }
            }
        } else {
            return Result.FORMAT_ERROR;
        }
    }

    public static Result sendToCMCC(String mobile, String content) {
//        String url = CommonUtils.assemblyURLQuestionMark(MOBILE_NOTE_CMCC_URL) + CommonUtils.assemblyURLParams("mobile", mobile)
//            + CommonUtils.assemblyURLParams("content", content);
//
//        try {
//            String response = HttpClientUtils.doHttpGet(url);
//            String status = XMLUtils.getText(response, "returnsms/returnstatus");
//            String msg = XMLUtils.getText(response, "returnsms/message");
//            LogUtil.DEBUG("parsed status:" + status + ", message:" + msg);
//            // 短信接口传送成功
//            if (StringUtils.isNotEmpty(status) && status.trim().equalsIgnoreCase("success")) {
//                return Result.RESPONSE_OK;
//            } else {
//                LogUtil.ERROR(String.format("短信接口【CMCC】异常，手机号：%s, 内容：%s, 返回：%s", mobile, content, response));
//            }
//        } catch (Exception e) {
//            LogUtil.ERROR("短信接口【CMCC】异常：", e.getMessage());
//        }
//        // 短信接口异常信息
//        return Result.RESPONSE_ERROR;
        
        MasServiceSoapProxy proxy = new MasServiceSoapProxy();
        
        String userName = "cdwk";
        String password = "1234@abcd";
        String[] destAddr = new String[]{mobile};
        try {
            SendSmsResult result = proxy.sendSms(userName, MD5.getStr2Digest(password), destAddr, content, "");
            if (result.getErrorMessage() == null) {
                return Result.RESPONSE_OK;
            }else{
                LogUtil.DEBUG("联通短信发送结果:"+result.getErrorCode()+"_"+result.getErrorMessage());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            LogUtil.ERROR(e.getMessage());
            
        }
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
     * @param mobile
     * @return 验证通过返回true
     */
    public static boolean isMobile(String mobile) {
        return StringUtils.isNotEmpty(mobile) ? Pattern.compile(MOBILE_REGEX).matcher(mobile).matches() : false;
    }

    /**
     * 获取手机运营商
     * @param mobile
     * @return
     */
    public static MobileServiceProvider getServiceProvider(String mobile) {
        if(Pattern.compile(TELECOM_REGEX).matcher(mobile).matches()){
            return MobileServiceProvider.TELECOM;
        } else if(Pattern.compile(UNICOM_REGEX).matcher(mobile).matches()){
            return MobileServiceProvider.UNICOM;
        } else if(Pattern.compile(CMCC_REGEX).matcher(mobile).matches()){
            return MobileServiceProvider.CMCC;
        } else {
            return MobileServiceProvider.OTHER;
        }
    }

    public static void main(String[] arg) throws UnsupportedEncodingException {
        System.out.println(getServiceProvider("17018511228"));
        
//        Random random = new Random();
//        String vc = String.format("%06d", random.nextInt(10000));
//        String msg = vc + "测试";
//        msg = "已为您开通好驾GPS服务，使用手机随时随地查询车辆信息。点击下载移动客户端：http://t.cn/RU3j1j5";
//        MobileUtil.send("18080435338", msg);
    }
}