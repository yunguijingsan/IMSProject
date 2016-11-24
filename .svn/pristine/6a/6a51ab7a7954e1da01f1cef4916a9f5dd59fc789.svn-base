package com.shine.view.service.ims.impl;

import com.shine.core.exception.ServiceException;
 //import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
 //import org.apache.log4j.Logger;
import com.shine.dao.ims.CazeDao;
import com.shine.entity.ims.Caze;
import com.shine.condition.ims.CazeCondition;
import  com.shine.view.service.ims.CazeService;
 //import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CazeServiceImpl  implements CazeService{
    //private static Logger logger = Logger.getLogger(CazeServiceImpl.class);

    @Autowired
    private CazeDao  cazeDao;

    public void addCaze(Caze  caze){ 
        validate( caze);
      //   try{
        	cazeDao.addCaze(caze);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("CAZE.ADD.FAIL");
       //  }
         
    }

    public Caze  findCazeById(Integer id){ 
        validateId(id);
        Caze caze;
        // try {
            caze= cazeDao.findCazeById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("CAZE.FIND.IS.FALL");
        // }
        
        return caze;
    }

    public void updateCaze( Caze caze){ 
        validateId(caze.getId());//TODO
        validate(caze);
             cazeDao.updateCaze( caze);
    }

    public Page<Caze> searchCaze(CazeCondition cazeCondition){ 
    	cazeCondition.setData(cazeDao.searchCaze(cazeCondition));
        return  cazeCondition;
    }

    private void validate(Caze  caze) {
        if ( caze == null) {
            throw ServiceException.create("CAZE.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("CAZE.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      cazeDao.apply();
    // }
}