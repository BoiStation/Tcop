package com.tcop.service;

import java.util.List;
import com.tcop.entity.Area;

public abstract interface AreaService
  extends BaseService<Area, Long>
{
  public abstract List<Area> findRoots();
  
  public abstract List<Area> findRoots(Integer paramInteger);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.AreaService
 * JD-Core Version:    0.7.0.1
 */