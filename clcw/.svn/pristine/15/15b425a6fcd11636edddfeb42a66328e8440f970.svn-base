package com.manzz.clcw.common.push;

import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;
import com.baidu.yun.push.auth.PushKeyPair;
import com.baidu.yun.push.client.BaiduPushClient;
import com.baidu.yun.push.exception.PushClientException;
import com.baidu.yun.push.exception.PushServerException;
import com.baidu.yun.push.model.PushMsgToSingleDeviceRequest;
import com.manzz.clcw.common.enums.SystemEnum.BaiduPushDeviceType;
import com.manzz.clcw.common.enums.SystemEnum.BaiduPushMsgType;
import com.manzz.framework.core.util.CommonUtils;
import com.manzz.framework.core.util.LogUtil;

/**
 * 功能:百度消息推送工具类
 * @author WJK
 * @version 2015-07 bccs-api-3.0.1.jar
 * @see http://push.baidu.com/doc/java/api
 */
public class BaiDuPushUtils {
    private final static String  BAIDU_PUSH_TITLE = CommonUtils.readResource("baidu.push.title");
    private final static String  ANDROID_API_KEY = CommonUtils.readResource("baidu.push.android.api.key");
    private final static String  ANDROID_SECRET_KEY = CommonUtils.readResource("baidu.push.android.secret.key");
    private final static String  IOS_API_KEY = CommonUtils.readResource("baidu.push.ios.api.key");
    private final static String  IOS_SECRET_KEY = CommonUtils.readResource("baidu.push.ios.secret.key");
    private final static Integer IOS_DEPLOY_STATUS = Integer.parseInt(CommonUtils.readResource("baidu.push.ios.deploy.status"));
    private final static PushKeyPair androidKeyPair;
    private final static PushKeyPair iosKeyPair;
    static {
        androidKeyPair = new PushKeyPair(ANDROID_API_KEY, ANDROID_SECRET_KEY);
        iosKeyPair = new PushKeyPair(IOS_API_KEY, IOS_SECRET_KEY);
    }
    
    public static void main(String[] args) {
//        System.out.println(pushMsg("4280461119909333417","can you receive it?"));
        System.out.println(pushMsgToAndroid("4280461119909333417","您有新的人车资质预警消息"));
    }

    /**
     * 功能: 推送单播消息到Andorid
     * @param baiduCI 百度频道ID
     * @param content 消息内容
     * @return 是否发送成功
     */
    public static boolean pushMsgToAndroid(String baiduCI, String content) {
        return pushMsg(baiduCI, content, BaiduPushMsgType.NOTICE,androidKeyPair,BaiduPushDeviceType.ANDROID);
    }
    
    /**
     * 功能: 推送单播消息到IOS
     * @param baiduCI 百度频道ID
     * @param content 消息内容
     * @return 是否发送成功
     */
    public static boolean pushMsgToIOS(String baiduCI, String content) {
        return pushMsg(baiduCI, content, BaiduPushMsgType.NOTICE,iosKeyPair,BaiduPushDeviceType.IOS);
    }
    
    private static boolean pushMsg(String baiduCI, String content, BaiduPushMsgType msgType, PushKeyPair keyPair, BaiduPushDeviceType deviceTypeEnum) {
        BaiduPushClient pushClient = new BaiduPushClient(keyPair);
        pushClient.setChannelLogHandler(new MyYunLogHandler());
        String jsonMessage = String.format("{\"title\":\"%s\",\"description\":\"%s\"}", BAIDU_PUSH_TITLE, content);
        try {
            // 创建请求实例
            PushMsgToSingleDeviceRequest request = new PushMsgToSingleDeviceRequest();
            request.setChannelId(baiduCI);
            request.setMessageType(msgType.ordinal());
            request.setDeviceType(deviceTypeEnum.ordinal());
            request.setMessage(jsonMessage);
            
            if(BaiduPushDeviceType.IOS.equals(deviceTypeEnum)){
                request.setDeployStatus(IOS_DEPLOY_STATUS);//设置IOS发布状态
                request.setMessage(String.format("{\"title\":\"%s\",\"description\":\"%s\",\"badge\":1}", BAIDU_PUSH_TITLE, content));
            }

            // 执行Http请求
            pushClient.pushMsgToSingleDevice(request);
            return true;
        } catch (PushClientException e) {
            LogUtil.ERROR("百度推送消息客户端异常：" + e.getMessage());
        } catch (PushServerException  e) {
            // 处理服务端错误异常
            LogUtil.ERROR("百度推送消息服务端异常："
                + String.format("request_id: %d, error_code: %d, error_message: %s", e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
        return false;
    }
}

class MyYunLogHandler implements YunLogHandler{
    @Override
    public void onHandle(YunLogEvent event) {
        LogUtil.DEBUG("百度推送消息onHandle:" + event.getMessage());
    }
}