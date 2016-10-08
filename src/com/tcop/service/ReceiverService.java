package com.tcop.service;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Member;
import com.tcop.entity.Receiver;

public abstract interface ReceiverService
  extends BaseService<Receiver, Long>
{
  public abstract Receiver findDefault(Member paramMember);
  
  public abstract Page<Receiver> findPage(Member paramMember, Pageable paramPageable);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.ReceiverService
 * JD-Core Version:    0.7.0.1
 */