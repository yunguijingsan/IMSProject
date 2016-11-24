package com.shine.view.service.ims.impl;

import com.shine.core.exception.ServiceException;
 //import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
 //import org.apache.log4j.Logger;
import com.shine.dao.ims.ParamDefinetionDao;
import com.shine.entity.ims.ParamDefinetion;
import com.shine.condition.ims.ParamDefinetionCondition;
import  com.shine.view.service.ims.ParamDefinetionService;
 //import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ParamDefinetionServiceImpl  implements ParamDefinetionService{
    //private static Logger logger = Logger.getLogger(ParamDefinetionServiceImpl.class);

    @Autowired
    private ParamDefinetionDao  paramDefinetionDao;

    public void addParamDefinetion(ParamDefinetion  paramDefinetion){ 
        validate( paramDefinetion);
      //   try{
        	paramDefinetionDao.addParamDefinetion(paramDefinetion);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("PARAMDEFINETION.ADD.FAIL");
       //  }
         
    }

    public ParamDefinetion  findParamDefinetionById(Integer id){ 
        validateId(id);
        ParamDefinetion paramDefinetion;
        // try {
            paramDefinetion= paramDefinetionDao.findParamDefinetionById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("PARAMDEFINETION.FIND.IS.FALL");
        // }
        
        return paramDefinetion;
    }

    public void updateParamDefinetion( ParamDefinetion paramDefinetion){ 
        validateId(1);//TODO
        validate(paramDefinetion);
        // try {
             paramDefinetionDao.updateParamDefinetion( paramDefinetion);
        // } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("PARAMDEFINETION.UPDATE.FAIL");
        // }
    }

    public Page<ParamDefinetion> searchParamDefinetion(ParamDefinetionCondition paramDefinetionCondition){ 
    	Page<ParamDefinetion>  paramDefinetions;
    	 //try {
            paramDefinetions =  paramDefinetionDao.searchParamDefinetion(paramDefinetionCondition);
       //  } catch (Exception e) {
         //  CommonUtils.printStackTraceInfo(logger, e);
         //  throw ServiceException.create("PARAMDEFINETION.SEARCH.FAIL");
       //  }
        return  paramDefinetions;
    }

    private void validate(ParamDefinetion  paramDefinetion) {
        if ( paramDefinetion == null) {
            throw ServiceException.create("PARAMDEFINETION.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("PARAMDEFINETION.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      paramDefinetionDao.apply();
    // }
}