package com.shine.view.controller.ims;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shine.core.utils.page.Page;
import com.shine.core.utils.spring.FunctionInfo;
import com.shine.core.exception.ResponseResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shine.entity.ims.Group;
import com.shine.view.service.ims.GroupService;
import com.shine.condition.ims.GroupCondition;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/ims/group")
public class GroupController{

    @Autowired
    private GroupService groupService;

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @FunctionInfo(functionName="URL组-添加")
    public ResponseResult addGroup(@RequestBody Group group){
    	groupService.addGroup(group);
	 	return ResponseResult.createSuccess(group);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    @FunctionInfo(functionName="URL组-详情")
    public ResponseResult findGroupById(Integer id){
    	Group group = groupService.findGroupById(id);
    	return ResponseResult.createSuccess(group);
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    @FunctionInfo(functionName="URL组-修改")
    public ResponseResult updateGroup(@RequestBody Group group){
    	groupService.updateGroup(group);
    	return ResponseResult.createSuccess(group);
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    @FunctionInfo(functionName="URL组-查询")
    public ResponseResult searchGroup(GroupCondition condition){
        Page<Group> group = groupService.searchGroup(condition);
        return ResponseResult.createSuccess(group);
    }
}