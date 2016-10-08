package com.tcop.service;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Deposit;
import com.tcop.entity.Member;

public abstract interface DepositService
  extends BaseService<Deposit, Long>
{
  public abstract Page<Deposit> findPage(Member paramMember, Pageable paramPageable);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.DepositService
 * JD-Core Version:    0.7.0.1
 */