/**
 * Project Name:datacenter
 * File Name:SystemEnum.java
 * Package Name:com.cht.datacenter.common.enums
 * Date:2015-07-28下午1:30:24
 * Copyright (c) 2015, cht.com All Rights Reserved.
 *
 */

package com.cht.ddhb.common.enums;

/**
 * 功能: 系统枚举类型
 * @author WJK
 * @version 2015-08 
 */
public class SystemEnum {
    /** 验证码类型 */
    @Deprecated
    public enum ValidCodeType{
        /** 0.其他未知 */
        OTHER,
        /** 1.注册 */
        REGISTER,
        /** 2.重置密码 */
        RESET_PWD
    }
    
    /** 会员用户类型 */
    public enum MemberType{
        /** 0.其他 */
        OTHER,
        /** 1.驾驶员 */
        DRIVER,
        /** 2.安管人员 */
        SECURITY_GUARD,
        /** 3.车主 */
        OWNER;
    }
    /** 手机类型 */
    public enum PhoneType{
        /** 0.其他 */
        OTHER,
        /** 1.安卓 */
        ANDROID,
        /** 2.苹果IOS */
        IOS;
    }
    /** 车牌颜色 */
    public enum PlateColor{
        /** 0.其他 */
        OTHER,
        /** 1.黄 */
        YELLOW,
        /** 2.蓝 */
        BLUE;
    }
    /** 司机资质状态 */
    public enum LicenseStatus{
        /** 0.正常 */
        NORMAL,
        /** 1.预警 */
        ALERT,
        /** 2.过期 */
        EXPIRE;
    }
    /** 百度推送类型 */
    public enum BaiduPushDeviceType{
        /** 0.其他 */
        OTHER,
        /** 1.网站 */
        WEB,
        /** 2.个人电脑 */
        PC,
        /** 3.安卓 */
        ANDROID,
        /** 4.苹果IOS */
        IOS,
        /** 5.Windows Phone */
        WP
    }
    /** 百度推送类型 */
    public enum BaiduPushMsgType{
        /** 0.透传消息：发送后不会在系统通知栏展现，SDK将消息传给第三方应用后需要开发者写展现代码才能看到 */
        PASS_THROUGH,
        /** 1.通知：发送后会在系统通知栏收到展现，同时响铃或振动提醒用户 */
        NOTICE
    }
}

