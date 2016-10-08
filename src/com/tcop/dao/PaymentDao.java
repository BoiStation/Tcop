package com.tcop.dao;

import com.tcop.entity.Payment;

public abstract interface PaymentDao
  extends BaseDao<Payment, Long>
{
  public abstract Payment findBySn(String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.PaymentDao
 * JD-Core Version:    0.7.0.1
 */