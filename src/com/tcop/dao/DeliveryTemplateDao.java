package com.tcop.dao;

import com.tcop.entity.DeliveryTemplate;

public abstract interface DeliveryTemplateDao
  extends BaseDao<DeliveryTemplate, Long>
{
  public abstract DeliveryTemplate findDefault();
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.DeliveryTemplateDao
 * JD-Core Version:    0.7.0.1
 */