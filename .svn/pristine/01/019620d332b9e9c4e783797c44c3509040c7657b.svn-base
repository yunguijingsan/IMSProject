package com.shine.view.service.ims.impl;

import com.shine.core.exception.ServiceException;
 //import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
 //import org.apache.log4j.Logger;
import com.shine.dao.ims.ServerDao;
import com.shine.entity.ims.Server;
import com.shine.condition.ims.ServerCondition;
import  com.shine.view.service.ims.ServerService;
 //import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ServerServiceImpl  implements ServerService{
    //private static Logger logger = Logger.getLogger(ServerServiceImpl.class);

    @Autowired
    private ServerDao  serverDao;

    public void addServer(Server  server){ 
        validate( server);
      //   try{
        	serverDao.addServer(server);
        // }catch(Exception e){
             //CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("SERVER.ADD.FAIL");
       //  }
         
    }

    public Server  findServerById(Integer id){ 
        validateId(id);
        Server server;
        // try {
            server= serverDao.findServerById(id);
       //  } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("SERVER.FIND.IS.FALL");
        // }
        
        return server;
    }

    public void updateServer( Server server){ 
        validateId(1);//TODO
        validate(server);
        // try {
             serverDao.updateServer( server);
        // } catch (Exception e) {
        //     CommonUtils.printStackTraceInfo(logger, e);
        //     throw ServiceException.create("SERVER.UPDATE.FAIL");
        // }
    }

    public Page<Server> searchServer(ServerCondition serverCondition){ 
    	serverCondition.setData(this.serverDao.searchServer(serverCondition));
        return  serverCondition;
    }

    private void validate(Server  server) {
        if ( server == null) {
            throw ServiceException.create("SERVER.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("SERVER.ID.IS.NULL");
        }
    }

    // public void apply() {
    //      serverDao.apply();
    // }
}