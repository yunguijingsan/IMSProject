package com.shine.view.service.ims.impl;

import com.shine.core.exception.ServiceException;
 //import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
 //import org.apache.log4j.Logger;
import com.shine.dao.ims.GroupDao;
import com.shine.entity.ims.Group;
import com.shine.condition.ims.GroupCondition;
import  com.shine.view.service.ims.GroupService;
 //import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class GroupServiceImpl  implements GroupService{
    //private static Logger logger = Logger.getLogger(GroupServiceImpl.class);

    @Autowired
    private GroupDao  groupDao;

    public void addGroup(Group  group){ 
        validate( group);
      //   try{
        	groupDao.addGroup(group);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("GROUP.ADD.FAIL");
       //  }
         
    }

    public Group  findGroupById(Integer id){ 
        validateId(id);
        Group group;
        // try {
            group= groupDao.findGroupById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("GROUP.FIND.IS.FALL");
        // }
        
        return group;
    }

    public void updateGroup( Group group){ 
        validateId(1);//TODO
        validate(group);
        // try {
             groupDao.updateGroup( group);
        // } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("GROUP.UPDATE.FAIL");
        // }
    }

    public Page<Group> searchGroup(GroupCondition groupCondition){ 
    	groupCondition.setData(groupDao.searchGroup(groupCondition));
        return  groupCondition;
    }

    private void validate(Group  group) {
        if ( group == null) {
            throw ServiceException.create("GROUP.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("GROUP.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      groupDao.apply();
    // }
}