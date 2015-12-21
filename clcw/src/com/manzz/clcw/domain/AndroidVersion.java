
package com.manzz.clcw.domain;

import com.manzz.framework.core.util.CommonUtils;

/**
 * 安卓版本信息
 */
public class AndroidVersion {
    private String urlAppDownload;//应用下载地址
    private String appVersion;    //应用最新版本
    private String appLog;        //应用更新日志
    
    public AndroidVersion(){
        this.urlAppDownload = CommonUtils.readResource("url.app.download", true);
        this.appVersion = CommonUtils.readResource("app.version", true);
        this.appLog = CommonUtils.readResource("app.log", true);
    }
    
    public String getUrlAppDownload() {
        return urlAppDownload;
    }
    
    public void setUrlAppDownload(String urlAppDownload) {
        this.urlAppDownload = urlAppDownload;
    }
    
    public String getAppVersion() {
        return appVersion;
    }
    
    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
    
    public String getAppLog() {
        return appLog;
    }
    
    public void setAppLog(String appLog) {
        this.appLog = appLog;
    }
}

