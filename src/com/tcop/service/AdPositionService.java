package com.tcop.service;

import com.tcop.entity.AdPosition;

public abstract interface AdPositionService
  extends BaseService<AdPosition, Long>
{
  public abstract AdPosition find(Long paramLong, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.AdPositionService
 * JD-Core Version:    0.7.0.1
 */