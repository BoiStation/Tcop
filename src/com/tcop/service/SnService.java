package com.tcop.service;

import com.tcop.entity.Sn;
import com.tcop.entity.Sn.Type;

public abstract interface SnService
{
  public abstract String generate(Sn.Type paramType);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.SnService
 * JD-Core Version:    0.7.0.1
 */