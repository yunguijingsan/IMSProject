package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.ParamDefinetion;
import com.shine.view.service.ims.ParamDefinetionService;
import com.shine.condition.ims.ParamDefinetionCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/paramDefinetion")
public class ParamDefinetionController{

    @Autowired
    private ParamDefinetionService paramDefinetionService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="参数定义-添加")
    public ResponseResult addParamDefinetion(@RequestBody ParamDefinetion paramDefinetion){
    	paramDefinetionService.addParamDefinetion(paramDefinetion);
	 	return ResponseResult.createSuccess(paramDefinetion);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="参数定义-详情")
    public ResponseResult findParamDefinetionById(Integer id){
    	ParamDefinetion paramDefinetion = paramDefinetionService.findParamDefinetionById(id);
    	return ResponseResult.createSuccess(paramDefinetion);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="参数定义-修改")
    public ResponseResult updateParamDefinetion(@RequestBody ParamDefinetion paramDefinetion){
    	paramDefinetionService.updateParamDefinetion(paramDefinetion);
    	return ResponseResult.createSuccess(paramDefinetion);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="参数定义-查询")
    public ResponseResult searchParamDefinetion(ParamDefinetionCondition condition){
        Page<ParamDefinetion> paramDefinetion = paramDefinetionService.searchParamDefinetion(condition);
        return ResponseResult.createSuccess(paramDefinetion);
    }
}