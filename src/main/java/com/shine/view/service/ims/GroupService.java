package com.shine.view.service.ims;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.ims.Group;
import com.shine.condition.ims.GroupCondition;

public interface GroupService extends BaseService{

    public void addGroup(Group group);

    public Group findGroupById(Integer id);

    public void updateGroup(Group group);

    public Page<Group> searchGroup( GroupCondition groupCondition );
}