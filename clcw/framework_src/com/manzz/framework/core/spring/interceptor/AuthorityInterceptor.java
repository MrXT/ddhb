package com.manzz.framework.core.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.manzz.clcw.module.sm.web.vo.SmUserVo;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.util.StringUtils;

/**
 * 实现访问权限的控制
 * @author WJK
 * @version:1.0 2014-12
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
	    //判断是否可以直接访问
        if(isPermitedUrl(request.getRequestURI())) 
            return true;
        //完成head.jsp功能模块展示效果的逻辑，把请求的路径放到request里面
         request.setAttribute("requestPath", request.getRequestURI());
        //解决IFRAME中SESSION无法保留的问题
        response.setHeader("P3P","CP=CAO PSA OUR");
	    
        //判断是否登录或session是否过期
        HttpSession session = request.getSession();
        if(session == null || (session.getAttribute(Constants.DEFAULT_SESSION_USER) == null)){
            String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
            response.sendRedirect(basePath + "nosession"); 
            return false;
        }
		
        //将当前用户信息存放到线程中
        SessionHolder.setCurrentUser((SmUserVo)session.getAttribute(Constants.DEFAULT_SESSION_USER));
        SessionHolder.setIpAddress(getIpAddr(request));
        return true;
	}

    /** 判断是否为允许直接访问的url*/
    private boolean isPermitedUrl(String url) {
        String[] permitedUrls = Constants.DEFAULT_PERMITED_URLS;
        for(String permitedUrl:permitedUrls){
            if(url.endsWith(permitedUrl)) 
                return true;
        }
        if(url.contains("/ws/")){
            return true;
        }
        return false;
    }
    
//    /** 判断用户是否有足够权限*/
//    private boolean hasAuthority(String url, List<SmRes> limitedResList) {
//        String path = url.substring(url.indexOf("/", 2)+1);
//        for(SmRes res:limitedResList){
//            if(path.equals(res.getResUrl())){
//                return false;
//            }
//        }
//        return true;
//    }
    
    /** 获取用户ip */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
