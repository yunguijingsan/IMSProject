package com.shine.view.service.ims.impl;

import com.shine.core.exception.ServiceException;
 //import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
 //import org.apache.log4j.Logger;
import com.shine.dao.ims.ResultDao;
import com.shine.entity.ims.Result;
import com.shine.condition.ims.ResultCondition;
import  com.shine.view.service.ims.ResultService;
 //import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ResultServiceImpl  implements ResultService{
    //private static Logger logger = Logger.getLogger(ResultServiceImpl.class);

    @Autowired
    private ResultDao  resultDao;

    public void addResult(Result  result){ 
        validate( result);
      //   try{
        	resultDao.addResult(result);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("RESULT.ADD.FAIL");
       //  }
         
    }

    public Result  findResultById(Integer id){ 
        validateId(id);
        Result result;
        // try {
            result= resultDao.findResultById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("RESULT.FIND.IS.FALL");
        // }
        
        return result;
    }

    public void updateResult( Result result){ 
        validateId(1);//TODO
        validate(result);
        // try {
             resultDao.updateResult( result);
        // } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("RESULT.UPDATE.FAIL");
        // }
    }

    public Page<Result> searchResult(ResultCondition resultCondition){ 
    	resultCondition.setData(this.resultDao.searchResult(resultCondition));
        return  resultCondition;
    }

    private void validate(Result  result) {
        if ( result == null) {
            throw ServiceException.create("RESULT.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("RESULT.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      resultDao.apply();
    // }
}