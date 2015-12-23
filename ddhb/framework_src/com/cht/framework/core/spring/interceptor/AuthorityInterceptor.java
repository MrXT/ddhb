package com.cht.framework.core.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cht.ddhb.common.web.vo.SmUserVo;
import com.cht.ddhb.domain.SmRes;
import com.cht.framework.core.common.Constants;
import com.cht.framework.core.common.SessionHolder;
import com.cht.framework.core.util.StringUtils;

/**
 * 实现访问权限的控制
 * @author WJK
 * @version:1.0 2014-12
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置是否可以跨域访问
        // response.addHeader("Access-Control-Allow-Origin", "*");
        // 判断是否可以直接访问
        if (isPermitedUrl(request.getRequestURI())){
            /**
             *  暂时去掉权限的验证
             */
            SessionHolder.setCurrentUser((SmUserVo) request.getSession().getAttribute(Constants.DEFAULT_SESSION_USER));
            return true;
        }

        // 解决IFRAME中SESSION无法保留的问题
        response.setHeader("P3P", "CP=CAO PSA OUR");

        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        // 判断是否登录或session是否过期
        HttpSession session = request.getSession();
        if (session == null || (session.getAttribute(Constants.DEFAULT_SESSION_USER) == null)) {
            response.sendRedirect(basePath + "nosession");
            return false;
        }

        // 判断访问权限TODO
        List<SmRes> reses = ((SmUserVo) session.getAttribute(Constants.DEFAULT_SESSION_USER)).getReses();
        if (hasAuthority(request.getRequestURI(), reses)) {
            // 将当前用户信息存放到线程中
            SessionHolder.setCurrentUser((SmUserVo) session.getAttribute(Constants.DEFAULT_SESSION_USER));
            SessionHolder.setIpAddress(getIpAddr(request));
            return true;
        } else {
            response.sendRedirect(basePath + "nores");
            return false;
        }
    }

    /** 判断是否为允许直接访问的url */
    private boolean isPermitedUrl(String url) {
        String[] permitedUrls = Constants.DEFAULT_PERMITED_URLS;
        for (String permitedUrl : permitedUrls) {
            if (url.endsWith(permitedUrl))
                return true;
        }
        /**
         * 先去掉权限的验证,方便开发
         */
        /*if (url.contains("/ws/")) {
            return true;
        }*/
        if (url.contains("")) {
            return true;
        }
        return false;
    }

    // /** 判断用户是否有足够权限*/
    private boolean hasAuthority(String url, List<SmRes> reses) {
        String path = url.substring(url.indexOf("/", 2) + 1);
        for (SmRes res : reses) {
            if (path.equals(res.getUrl())) {
                return true;
            }
        }
        return false;
    }

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
