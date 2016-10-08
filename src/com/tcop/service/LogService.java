package com.tcop.service;

import com.tcop.entity.Log;

public abstract interface LogService
  extends BaseService<Log, Long>
{
  public abstract void clear();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.LogService
 * JD-Core Version:    0.7.0.1
 */