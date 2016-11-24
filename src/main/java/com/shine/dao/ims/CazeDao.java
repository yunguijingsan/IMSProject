package com.shine.dao.ims;

import java.util.List;

import com.shine.dao.BaseDao;
import com.shine.entity.ims.Caze;
import com.shine.condition.ims.CazeCondition;

public interface CazeDao extends BaseDao{

    public void addCaze(Caze caze);

    public Caze findCazeById(Integer id);

    public void updateCaze(Caze caze);

    public List<Caze> searchCaze(CazeCondition cazeCondition);
}