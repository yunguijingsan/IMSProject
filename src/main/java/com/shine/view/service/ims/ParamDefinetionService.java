package com.shine.view.service.ims;

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import com.shine.entity.ims.ParamDefinetion;
import com.shine.condition.ims.ParamDefinetionCondition;

public interface ParamDefinetionService extends BaseService{

    public void addParamDefinetion(ParamDefinetion paramDefinetion);

    public ParamDefinetion findParamDefinetionById(Integer id);

    public void updateParamDefinetion(ParamDefinetion paramDefinetion);

    public Page<ParamDefinetion> searchParamDefinetion( ParamDefinetionCondition paramDefinetionCondition );
}