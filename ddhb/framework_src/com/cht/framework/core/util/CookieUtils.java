/*
 * @(#)CookieUtils.java  1.0 2009-1-30上午11:31:59
 *
 * 上海民航华东凯亚系统集成有限公司
 * CopyRight 1999-2009 Cares, Inc. All rights reserved.
 */
package com.cht.framework.core.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ye
 * @version 1.0, 2009-1-30
 */
public class CookieUtils {

	
	public static String domain;
	public static String path;
	
    static public void setCookie(HttpServletResponse response, String name, String value) {   	
        int age = -1;
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(age);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setSecure(false);
        response.addCookie(cookie);
    }

    static public String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(name)) {
                    cookie = cookies[i];
                    break;
                }
            }
        }
        if (cookie != null)
            return cookie.getValue();
        return null;
    }
    
        
	public static void setDomain(String domain) {
		CookieUtils.domain = domain;
	}

	public static void setPath(String path) {
		CookieUtils.path = path;
	}

}
