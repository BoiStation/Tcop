package com.tcop.dao;

import java.util.List;
import com.tcop.entity.FriendLink;
import com.tcop.entity.FriendLink.Type;

public abstract interface FriendLinkDao
  extends BaseDao<FriendLink, Long>
{
  public abstract List<FriendLink> findList(FriendLink.Type paramType);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.FriendLinkDao
 * JD-Core Version:    0.7.0.1
 */