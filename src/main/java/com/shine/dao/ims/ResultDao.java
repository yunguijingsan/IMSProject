package com.shine.dao.ims;

import java.util.List;

import com.shine.dao.BaseDao;
import com.shine.entity.ims.Result;
import com.shine.condition.ims.ResultCondition;

public interface ResultDao extends BaseDao{

    public void addResult(Result result);

    public Result findResultById(Integer id);

    public void updateResult(Result result);

    public List<Result> searchResult(ResultCondition resultCondition);
}