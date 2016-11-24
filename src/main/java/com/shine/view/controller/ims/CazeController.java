package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Caze;
import com.shine.view.service.ims.CazeService;
import com.shine.condition.ims.CazeCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/caze")
public class CazeController{

    @Autowired
    private CazeService cazeService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="用例-添加")
    public ResponseResult addCaze(@RequestBody Caze caze){
    	cazeService.addCaze(caze);
	 	return ResponseResult.createSuccess(caze);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="用例-详情")
    public ResponseResult findCazeById(Integer id){
    	Caze caze = cazeService.findCazeById(id);
    	return ResponseResult.createSuccess(caze);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="用例-修改")
    public ResponseResult updateCaze(@RequestBody Caze caze){
    	cazeService.updateCaze(caze);
    	return ResponseResult.createSuccess(caze);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="用例-查询")
    public ResponseResult searchCaze(CazeCondition condition){
        Page<Caze> caze = cazeService.searchCaze(condition);
        return ResponseResult.createSuccess(caze);
    }
}