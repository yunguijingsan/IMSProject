package com.shine.view.service.ims.impl;

//import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
//import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;

import com.shine.condition.ims.ApplicationCondition;
import com.shine.core.exception.ServiceException;
import com.shine.core.utils.page.Page;
//import org.apache.log4j.Logger;
import com.shine.dao.ims.ApplicationDao;
import com.shine.entity.ims.Application;
import com.shine.view.service.ims.ApplicationService;


@Service
public class ApplicationServiceImpl  implements ApplicationService{
    //private static Logger logger = Logger.getLogger(ApplicationServiceImpl.class);

    @Autowired
    private ApplicationDao  applicationDao;

    public void addApplication(Application  application){ 
        validate( application);
      //   try{
        	applicationDao.addApplication(application);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("APPLICATION.ADD.FAIL");
       //  }
         
    }

    public Application  findApplicationById(Integer id){ 
        validateId(id);
        Application application;
        // try {
            application= applicationDao.findApplicationById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("APPLICATION.FIND.IS.FALL");
        // }
        
        return application;
    }

    public void updateApplication( Application application){ 
        validateId(application.getId());
        validate(application);
        // try {
             applicationDao.updateApplication( application);
        // } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("APPLICATION.UPDATE.FAIL");
        // }
    }

    public Page<Application> searchApplication(ApplicationCondition applicationCondition){ 
    	applicationCondition.setData(this.applicationDao.searchApplication(applicationCondition));
        return  applicationCondition;
    }

    private void validate(Application  application) {
        if ( application == null) {
            throw ServiceException.create("APPLICATION.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("APPLICATION.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      applicationDao.apply();
    // }
}