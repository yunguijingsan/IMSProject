package com.shine.view.service.ims;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.ims.Application;
import com.shine.condition.ims.ApplicationCondition;

public interface ApplicationService extends BaseService{

    public void addApplication(Application application);

    public Application findApplicationById(Integer id);

    public void updateApplication(Application application);

    public Page<Application> searchApplication( ApplicationCondition applicationCondition );
}