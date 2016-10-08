package com.tcop.dao;

import java.util.List;
import com.tcop.entity.Navigation;
import com.tcop.entity.Navigation.Position;

public abstract interface NavigationDao
  extends BaseDao<Navigation, Long>
{
  public abstract List<Navigation> findList(Navigation.Position paramPosition);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.NavigationDao
 * JD-Core Version:    0.7.0.1
 */