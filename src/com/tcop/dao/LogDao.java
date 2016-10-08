package com.tcop.dao;

import com.tcop.entity.Log;

public abstract interface LogDao
  extends BaseDao<Log, Long>
{
  public abstract void removeAll();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.LogDao
 * JD-Core Version:    0.7.0.1
 */