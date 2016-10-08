package com.tcop.service;

import com.tcop.entity.DeliveryCenter;

public abstract interface DeliveryCenterService
  extends BaseService<DeliveryCenter, Long>
{
  public abstract DeliveryCenter findDefault();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.DeliveryCenterService
 * JD-Core Version:    0.7.0.1
 */