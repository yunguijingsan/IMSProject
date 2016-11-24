package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Result;
import com.shine.view.service.ims.ResultService;
import com.shine.condition.ims.ResultCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/result")
public class ResultController{

    @Autowired
    private ResultService resultService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="结果-添加")
    public ResponseResult addResult(@RequestBody Result result){
    	resultService.addResult(result);
	 	return ResponseResult.createSuccess(result);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="结果-详情")
    public ResponseResult findResultById(Integer id){
    	Result result = resultService.findResultById(id);
    	return ResponseResult.createSuccess(result);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="结果-修改")
    public ResponseResult updateResult(@RequestBody Result result){
    	resultService.updateResult(result);
    	return ResponseResult.createSuccess(result);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="结果-查询")
    public ResponseResult searchResult(ResultCondition condition){
        Page<Result> result = resultService.searchResult(condition);
        return ResponseResult.createSuccess(result);
    }
}