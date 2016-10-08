package com.tcop.service;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Message;

public abstract interface MessageService
  extends BaseService<Message, Long>
{
  public abstract Page<Message> findPage(Member paramMember, Pageable paramPageable);
  
  public abstract Page<Message> findDraftPage(Member paramMember, Pageable paramPageable);
  
  public abstract Long count(Member paramMember, Boolean paramBoolean);
  
  public abstract void delete(Long paramLong, Member paramMember);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.MessageService
 * JD-Core Version:    0.7.0.1
 */