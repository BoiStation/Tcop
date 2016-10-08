package com.tcop.dao;

import java.util.List;
import java.util.Set;
import com.tcop.entity.Parameter;
import com.tcop.entity.ParameterGroup;

public abstract interface ParameterDao
  extends BaseDao<Parameter, Long>
{
  public abstract List<Parameter> findList(ParameterGroup paramParameterGroup, Set<Parameter> paramSet);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ParameterDao
 * JD-Core Version:    0.7.0.1
 */