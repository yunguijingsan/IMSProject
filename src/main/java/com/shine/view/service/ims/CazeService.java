package com.shine.view.service.ims;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.ims.Caze;
import com.shine.condition.ims.CazeCondition;

public interface CazeService extends BaseService{

    public void addCaze(Caze caze);

    public Caze findCazeById(Integer id);

    public void updateCaze(Caze caze);

    public Page<Caze> searchCaze( CazeCondition cazeCondition );
}