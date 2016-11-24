package com.shine.dao.ims;

import com.shine.core.utils.page.Page;
import com.shine.dao.BaseDao;
import com.shine.entity.ims.ParamDefinetion;
import com.shine.condition.ims.ParamDefinetionCondition;

public interface ParamDefinetionDao extends BaseDao{

    public void addParamDefinetion(ParamDefinetion paramDefinetion);

    public ParamDefinetion findParamDefinetionById(Integer id);

    public void updateParamDefinetion(ParamDefinetion paramDefinetion);

    public Page<ParamDefinetion> searchParamDefinetion(ParamDefinetionCondition paramDefinetionCondition);
}