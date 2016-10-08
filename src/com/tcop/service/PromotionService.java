package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.entity.Promotion;

public abstract interface PromotionService
  extends BaseService<Promotion, Long>
{
  public abstract List<Promotion> findList(Boolean paramBoolean1, Boolean paramBoolean2, Integer paramInteger, List<Filter> paramList, List<Order> paramList1);
  
  public abstract List<Promotion> findList(Boolean paramBoolean1, Boolean paramBoolean2, Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.PromotionService
 * JD-Core Version:    0.7.0.1
 */