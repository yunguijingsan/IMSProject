package com.shine.view.service.ims;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.ims.Server;
import com.shine.condition.ims.ServerCondition;

public interface ServerService extends BaseService{

    public void addServer(Server server);

    public Server findServerById(Integer id);

    public void updateServer(Server server);

    public Page<Server> searchServer( ServerCondition serverCondition );
}