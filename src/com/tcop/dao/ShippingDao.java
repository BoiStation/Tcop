package com.tcop.dao;

import com.tcop.entity.Shipping;

public abstract interface ShippingDao
  extends BaseDao<Shipping, Long>
{
  public abstract Shipping findBySn(String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.ShippingDao
 * JD-Core Version:    0.7.0.1
 */