package com.shine.dao.ims;

import java.util.List;

import com.shine.dao.BaseDao;
import com.shine.entity.ims.Group;
import com.shine.condition.ims.GroupCondition;

public interface GroupDao extends BaseDao{

    public void addGroup(Group group);

    public Group findGroupById(Integer id);

    public void updateGroup(Group group);

    public List<Group> searchGroup(GroupCondition groupCondition);
}