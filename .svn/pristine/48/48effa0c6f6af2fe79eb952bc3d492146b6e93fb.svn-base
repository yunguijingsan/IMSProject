package com.shine.core.utils.spring;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.UrlPathHelper;

public class GetRequestMappingInfo {
	@Autowired
	private RequestMappingHandlerMapping rmhp;
	
	 @SuppressWarnings("unused")
	public Object getUrlMapping(HttpServletRequest request) {  
	        WebApplicationContext wc = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getSession().getServletContext());  
	        RequestMappingHandlerMapping bean = wc.getBean(RequestMappingHandlerMapping.class);
	        Map<RequestMappingInfo, HandlerMethod> map = rmhp.getHandlerMethods();  
	        UrlPathHelper urlPathHelper = rmhp.getUrlPathHelper();
	        for(RequestMappingInfo info : map.keySet()){  
	            System.out.println(map.get(info).getBean().toString()+","+info.getPatternsCondition().toString()
	                    +","+ info.getMethodsCondition().toString());  
	        }  
	        return null;  
	    }  
}
