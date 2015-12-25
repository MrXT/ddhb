package com.cht.framework.core.common;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.framework.core.util.CommonUtils;

/**
 * 用来存取当前Session的线程级变量
 * @author: XT    
 * @version 1.0 2015-12
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
    public static Short getCompanyId() {   
        return getCurrentUser().getCompanyId(); 
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
	
	/**
	 * 功能:是否为系统管理员
	 * @return
	 */
	public static boolean isAdmin() {
		return getCurrentUser().getRoleId().equals(CommonUtils.readResource("defalut.superadmin.roleId"));
	}
	
}
