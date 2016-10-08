package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.entity.Navigation;
import com.tcop.entity.Navigation.Position;

public abstract interface NavigationService
  extends BaseService<Navigation, Long>
{
  public abstract List<Navigation> findList(Navigation.Position paramPosition);
  
  public abstract List<Navigation> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.NavigationService
 * JD-Core Version:    0.7.0.1
 */