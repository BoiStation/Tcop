package com.tcop.service;

import java.util.List;
import com.tcop.Filter;
import com.tcop.Order;
import com.tcop.entity.FriendLink;
import com.tcop.entity.FriendLink.Type;

public abstract interface FriendLinkService
  extends BaseService<FriendLink, Long>
{
  public abstract List<FriendLink> findList(FriendLink.Type paramType);
  
  public abstract List<FriendLink> findList(Integer paramInteger, List<Filter> paramList, List<Order> paramList1, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.FriendLinkService
 * JD-Core Version:    0.7.0.1
 */