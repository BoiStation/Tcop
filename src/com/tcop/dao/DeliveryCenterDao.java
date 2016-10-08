package com.tcop.dao;

import com.tcop.entity.DeliveryCenter;

public abstract interface DeliveryCenterDao
  extends BaseDao<DeliveryCenter, Long>
{
  public abstract DeliveryCenter findDefault();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.DeliveryCenterDao
 * JD-Core Version:    0.7.0.1
 */