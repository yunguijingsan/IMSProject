package com.shine.view.controller.ims;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shine.core.exception.ResponseResult;
import com.shine.core.utils.common.ServletObjectContext;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.view.service.CommonService;

@Controller
@RequestMapping("/resources/ims/common")
public class CommonController {

	@Autowired
	CommonService commonService;

	@ResponseBody
	@RequestMapping(value = "functions", method = RequestMethod.GET)
	@FunctionInfo(functionName="通用-获取所有的接口")
	public ResponseResult listFunctions() {
		WebApplicationContext wc = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletObjectContext
						.getHttpRequest().getServletContext());
		String[] allBeanName = wc.getBeanDefinitionNames(); // 得到所有bean的名称
		ArrayList<String> controllerNameList = new ArrayList<String>();
		for (int a = 0; a < allBeanName.length; a++) {
			if (allBeanName[a].contains("Controller")) { // 过滤bean中信息.只保存controller 
				// bean名称
				controllerNameList.add(allBeanName[a]);
			}
		}
		return ResponseResult.createSuccess(commonService
				.getRequestMappingInfo(controllerNameList));
	}
}
