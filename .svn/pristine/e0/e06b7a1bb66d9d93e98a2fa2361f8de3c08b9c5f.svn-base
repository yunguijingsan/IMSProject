package com.shine.view.service.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shine.core.exception.ResponseResult;
import com.shine.core.exception.ServiceException;
import com.shine.core.utils.common.CommonUtils;
import com.shine.core.utils.spring.ComplexPropertyPreFilter;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.entity.ims.ext.Functions;
import com.shine.view.service.CommonService;

@SuppressWarnings("deprecation")
@Service
public class CommonServiceImpl implements CommonService{
	
	  @Override
	    public List<Functions> getRequestMappingInfo(List<String> controllerNames) {
	
	        List<Functions> functions = new ArrayList<>();
	        //DOTO 把得到的URL 和请求方式  在和自定义标签 方法名匹配后新建
	        for (int i = 0; i < controllerNames.size(); i++) {
	            Class<?> controllerClazz = null;
	            try {
	                controllerClazz =
	                    Class.forName("com.shine.view.controller.ims."+ toUpperCaseFirstOne(controllerNames.get(i).toString()));
	            } catch (Exception e) {
	                // throw ServiceException.create("");
	                System.out.println("尚未找到该字节码");
	                continue;
	            }
	            RequestMapping controllerRequestMapping =
	                (RequestMapping) this.getControllerAnnotation(controllerClazz, RequestMapping.class);

	            if (CommonUtils.isBlank(controllerRequestMapping)) {
	                continue;
	            }

	            String controllerUrl = this.getUrlFromRequestMapping(controllerRequestMapping);
	            if (!CommonUtils.isBlank(controllerClazz)) {
	                for (Method m : controllerClazz.getMethods()) {
	                    if(!m.isAnnotationPresent(RequestMapping.class)){
	                        continue;
	                    }
	                    if(m.isAnnotationPresent(Deprecated.class)){
	                        continue;
	                    }
	                    Functions function = new Functions();
	                    try {
	                        RequestMapping methodRequestMapping =
	                            (RequestMapping) this.getMethodAnnotation(m, RequestMapping.class);

	                        function.setRestPath(this.getRequestUrl(controllerUrl, methodRequestMapping));
	                        function.setIrepMethodName(methodRequestMapping.method()[0].name());
	                        function.setFunctionName(this.getFunctionNameByUrl(function.getRestPath(),
	                                                                           function.getIrepMethodName()));
	                        setFunctionAnnotationInfo(m, function);
	                        function.setType("INTERFACE");
	                        function.setApplicationId(-1);
	                        function.setParameters(this.getParameters(m));
	                        functions.add(function);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                        throw ServiceException.create("FUNCTION.VALIDATE.RESTPATH.IS.NULL",new Object[]{controllerClazz.getName(),controllerUrl,m.getName()});
	                    }
	                }
	            }
	        }
	        return functions;
	    }


	    private Annotation getControllerAnnotation(Class<?> controllerClazz, Class<? extends Annotation> annotationClazz) {
	        if (controllerClazz.isAnnotationPresent(annotationClazz)) {
	            return controllerClazz.getAnnotation(annotationClazz);
	        }
	        return null;
	    }

	    private Annotation getMethodAnnotation(Method method, Class<? extends Annotation> annotationClazz) {
	        if (method.isAnnotationPresent(annotationClazz)) {
	            return method.getAnnotation(annotationClazz);
	        }
	        return null;
	    }

	    private String getUrlFromRequestMapping(RequestMapping requestMapping) {
	        //TODO 暂时只处理单路径映射
	        String url = null;

	        try {
	            url = requestMapping.value()[0];
	        } catch (Exception e) {
	        }
	        if (CommonUtils.isBlank(url)) {
	            return "/";
	        }
	        //确保路径以/开头
	        if (!url.startsWith("/")) {
	            url = "/" + url;
	        }
	        //确保不以/结尾
	        if(url.endsWith("/")){
	            url = url.substring(0,url.length()-1);
	        }
	        return url;
	    }

	    private String getRequestUrl(String controllerUrl, RequestMapping methodRequestMapping) {
	        String methodUrl = this.getUrlFromRequestMapping(methodRequestMapping);
	        if("/".equalsIgnoreCase(controllerUrl)){
	            return methodUrl;
	        }
	        String url =  controllerUrl + ("/".equals(methodUrl) ? "" : methodUrl);
	        return url.endsWith("/")? url.substring(0,url.length()-1) : url;
	    }

	    private String getFunctionNameByUrl(String url, String methodName) {
	        if (url.startsWith("/resources/")) {
	            url = url.substring("/resources/".length());
	        }
	        return (url.replace("/", "_") + "_" + methodName).toUpperCase();
	    }

	    private void setFunctionAnnotationInfo(Method method, Functions function) {
	       FunctionInfo functionInfo =
	            (FunctionInfo) this.getMethodAnnotation(method, FunctionInfo.class);
	        if(CommonUtils.isBlank(functionInfo)){
	            function.setUserFunctionName(function.getFunctionName());
	            function.setFunctionDescription(function.getFunctionName());
	        }else{
	            function.setUserFunctionName(CommonUtils.isBlank(functionInfo.functionName()) ? function.getFunctionName() :
	                                     functionInfo.functionName());
	            function.setFunctionDescription(CommonUtils.isBlank(functionInfo.functionDescription()) ?
	                                            function.getUserFunctionName() : functionInfo.functionDescription());
	    
	        }
	    }

	    private String getParameters(Method m) {
	       
	        Object obj = "";
	        try {
	            Class<?> clz = m.getParameterTypes()[0];
	            if(!clz.isPrimitive()){
	                obj = clz.newInstance();
	            }
	        } catch (Exception e) {
	            return "";
	        }
	        SerializeWriter serializeWriter = new SerializeWriter();
	        JSONSerializer serializer = new JSONSerializer(serializeWriter);
	        serializer.getPropertyFilters().add(new ComplexPropertyPreFilter(ResponseResult.createSuccess()));
	        serializer.config(SerializerFeature.WriteMapNullValue, true);
	        serializer.config(SerializerFeature.WriteNullBooleanAsFalse, true);
	        serializer.config(SerializerFeature.WriteNullNumberAsZero, true);
	        serializer.config(SerializerFeature.WriteNullStringAsEmpty, true);
	        serializer.write(obj);
	        return serializeWriter.toString();
	    }
	    
	    //首字母转大写
	    public static String toUpperCaseFirstOne(String s) {
	        if (Character.isUpperCase(s.charAt(0)))
	            return s;
	        else
	            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	    }
}
