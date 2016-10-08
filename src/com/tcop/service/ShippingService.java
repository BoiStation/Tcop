package com.tcop.service;

import java.util.Map;
import com.tcop.entity.Shipping;

public abstract interface ShippingService
  extends BaseService<Shipping, Long>
{
  public abstract Shipping findBySn(String paramString);
  
  public abstract Map<String, Object> query(Shipping paramShipping);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ShippingService
 * JD-Core Version:    0.7.0.1
 */