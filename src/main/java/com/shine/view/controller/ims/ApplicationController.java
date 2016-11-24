package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Application;
import com.shine.view.service.ims.ApplicationService;
import com.shine.condition.ims.ApplicationCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/application")
public class ApplicationController{

    @Autowired
    private ApplicationService applicationService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="应用-添加",functionDescription="应用-添加")
    public ResponseResult addApplication(@RequestBody Application application){
    	applicationService.addApplication(application);
	 	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="应用-详情")
    public ResponseResult findApplicationById(Integer id){
    	Application application = applicationService.findApplicationById(id);
    	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="应用-修改")
    public ResponseResult updateApplication(@RequestBody Application application){
    	applicationService.updateApplication(application);
    	return ResponseResult.createSuccess(application);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="应用-查询")
    public ResponseResult searchApplication(ApplicationCondition condition){
        Page<Application> application = applicationService.searchApplication(condition);
        return ResponseResult.createSuccess(application);
    }
}