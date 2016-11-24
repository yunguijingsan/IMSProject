package com.shine.core.utils.common;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class ServletObjectContext {
    
    
    public static ServletContext getApplication() {
        return RequestContextHolder.getRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getServletContext();
    }

    public static HttpSession getHttpSession() {
        return RequestContextHolder.getRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }
    public static HttpServletRequest getHttpRequest() {
        return RequestContextHolder.getRequestAttributes() == null ? null : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    public static String getSessionIdMd5(){
        return SignUtils.md5(getHttpSession().getId());
    }
    public static String getToken(){
        String token = getRequestParameter(getHttpRequest(),"token");
        if(null == token || "".equals(token)){
            token = getSessionIdMd5();
        }
 
        return token;
    }
    public static String getTokenEmptyIfNotExits(){
        String token = getRequestParameter(getHttpRequest(),"token");
        if(CommonUtils.isBlank(token)){
            token = "";
        }
        return token;
    }
    public static String getSign(){
        String sign = getRequestParameter(getHttpRequest(),"sign");
        if(sign.isEmpty()){
            sign = "";
        }
        return sign.toUpperCase();
    }
    public static String getRequestParameter(HttpServletRequest request, String paramName) {
        if(CommonUtils.isBlank(request)){
            return "";
        }
        String token = request.getParameter(paramName);
        if (CommonUtils.isBlank(token)) {
            token = getTokenFromCookie(request, paramName);
        }
        if (CommonUtils.isBlank(token)) {
            token = getParamFromHeader(request, paramName);
        }
        return token;
    }
    public static String getServer(){
      return  "http://"+getHttpRequest().getServerName()+":"+getHttpRequest().getServerPort()+getHttpRequest().getContextPath()+"/";
    }
    public static String getServerPath(){
      return  "http://"+getHttpRequest().getServerName()+":"+getHttpRequest().getServerPort();
    }

    public static String getTokenFromCookie(HttpServletRequest request, String paramName) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length == 0) {
                return "";
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(paramName)) {
                    return cookie.getValue();
                }
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return "";
    }

    private static String getParamFromHeader(HttpServletRequest request, String paramName) {
        return request.getHeader(paramName);
    }
}
