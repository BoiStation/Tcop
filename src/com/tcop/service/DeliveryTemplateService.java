package com.tcop.service;

import com.tcop.entity.DeliveryTemplate;

public abstract interface DeliveryTemplateService
  extends BaseService<DeliveryTemplate, Long>
{
  public abstract DeliveryTemplate findDefault();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.DeliveryTemplateService
 * JD-Core Version:    0.7.0.1
 */