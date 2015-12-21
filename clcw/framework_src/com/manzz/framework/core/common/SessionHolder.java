package com.manzz.framework.core.common;

import com.manzz.clcw.module.sm.web.vo.SmUserVo;

/**
 * 用来存取当前Session的线程级变量
 * @author: WJK    
 * @version 1.0 2014-09
 */
public class SessionHolder {
    private static ThreadLocal<SmUserVo> THREAD_LOCAL = new ThreadLocal<SmUserVo>();  
    private static String ipAddress = "";
      
    /**
     * 功能:把用户信息存放到当前线程
     * @param user
     */
    public static void setCurrentUser(SmUserVo user) {   
        THREAD_LOCAL.set(user);   
    }   
  
    /**
     * 功能:从当前线程中获取用户
     * @return
     */
    public static SmUserVo getCurrentUser() {  
        return THREAD_LOCAL.get()==null? new SmUserVo():THREAD_LOCAL.get();
    } 
    
    /**
     * 功能:获取登录用户企业ID
     */
    public static String getCompanyId() {   
        return getCurrentUser().getUserInfo().getCompany(); 
    }   
    
    /**
     * 功能:从当前线程中删除用户
     */
    public static void removeCurrentUser() {
        THREAD_LOCAL.remove();
    }
    
    /**
     * 功能:获取访问用户的IP地址
     * @return
     */
    public static String getIpAddress() {
        return ipAddress;
    }

    public static void setIpAddress(String ipAddress) {
        SessionHolder.ipAddress = ipAddress;
    }
    

}