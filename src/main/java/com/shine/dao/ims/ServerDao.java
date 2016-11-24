package com.shine.dao.ims;

import java.util.List;

import com.shine.condition.ims.ServerCondition;
import com.shine.dao.BaseDao;
import com.shine.entity.ims.Server;

public interface ServerDao extends BaseDao{

    public void addServer(Server server);

    public Server findServerById(Integer id);

    public void updateServer(Server server);

    public List<Server> searchServer(ServerCondition serverCondition);
}