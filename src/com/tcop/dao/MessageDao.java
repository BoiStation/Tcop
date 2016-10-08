package com.tcop.dao;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Message;

public abstract interface MessageDao
  extends BaseDao<Message, Long>
{
  public abstract Page<Message> findPage(Member paramMember, Pageable paramPageable);
  
  public abstract Page<Message> findDraftPage(Member paramMember, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Boolean paramBoolean);
  
  public abstract void remove(Long paramLong, Member paramMember);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.MessageDao
 * JD-Core Version:    0.7.0.1
 */