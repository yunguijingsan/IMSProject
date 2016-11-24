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
public class TestControlller{

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="服务地址-修改")
    public ResponseResult updateServer(@RequestBody Server server){    	
    	return ResponseResult.createSuccess(server);
    }
}