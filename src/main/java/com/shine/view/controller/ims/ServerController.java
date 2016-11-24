package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Server;
import com.shine.view.service.ims.ServerService;
import com.shine.condition.ims.ServerCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/server")
public class ServerController{

    @Autowired
    private ServerService serverService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="服务地址-添加")
    public ResponseResult addServer(@RequestBody Server server){
    	serverService.addServer(server);
	 	return ResponseResult.createSuccess(server);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="服务地址-详情")
    public ResponseResult findServerById(Integer id){
    	Server server = serverService.findServerById(id);
    	return ResponseResult.createSuccess(server);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="服务地址-修改")
    public ResponseResult updateServer(@RequestBody Server server){
    	serverService.updateServer(server);
    	return ResponseResult.createSuccess(server);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="服务地址-列表")
    public ResponseResult searchServer(ServerCondition condition){
        Page<Server> server = serverService.searchServer(condition);
        return ResponseResult.createSuccess(server);
    }
}