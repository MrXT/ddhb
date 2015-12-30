package com.cht.framework.core.common;

import com.cht.framework.core.util.CommonUtils;
/**
 * 静态常量定义
 * @author WJK
 * @version 2015-08
 */
public class Constants {
    public static final String   DEFAULT_SESSION_USER    = "user";
    public static final String   DEFAULT_LIMITED_RES     = "LIMITED_RES";
    public static final String   DEFAULT_WEB_ENCODING    = CommonUtils.readResource("default.web.encoding");
    public static final String   DEFAULT_DATE_FORMAT     = CommonUtils.readResource("default.date.format");
    public static final String   DEFAULT_DATETIME_FORMAT = CommonUtils.readResource("default.datetime.format");
    public static final String   DEFAULT_BLANK_SELECT    = CommonUtils.readResource("default.blank.select");
    public static final int      DEFAULT_PAGE_SIZE       = Integer.parseInt(CommonUtils.readResource("default.page.size"));
    public static final String[] DEFAULT_PERMITED_URLS   = CommonUtils.readResourceArray("default.permited.urls");
    public static final String DEFAULT_TOKEN   = "token";
    
}
