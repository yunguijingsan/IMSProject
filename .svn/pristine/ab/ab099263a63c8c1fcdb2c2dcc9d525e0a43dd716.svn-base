package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Url;
import com.shine.view.service.ims.UrlService;
import com.shine.condition.ims.UrlCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/url")
public class UrlController{

    @Autowired
    private UrlService urlService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="URL-添加")
    public ResponseResult addUrl(@RequestBody Url url){
    	urlService.addUrl(url);
	 	return ResponseResult.createSuccess(url);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="URL-详情")
    public ResponseResult findUrlById(Integer id){
    	Url url = urlService.findUrlById(id);
    	return ResponseResult.createSuccess(url);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="URL-修改")
    public ResponseResult updateUrl(@RequestBody Url url){
    	urlService.updateUrl(url);
    	return ResponseResult.createSuccess(url);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="URL-查询")
    public ResponseResult searchUrl(UrlCondition condition){
        Page<Url> url = urlService.searchUrl(condition);
        return ResponseResult.createSuccess(url);
    }
}