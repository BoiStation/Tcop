package com.tcop.dao;

import java.util.List;
import com.tcop.entity.Area;

public abstract interface AreaDao
  extends BaseDao<Area, Long>
{
  public abstract List<Area> findRoots(Integer paramInteger);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.AreaDao
 * JD-Core Version:    0.7.0.1
 */