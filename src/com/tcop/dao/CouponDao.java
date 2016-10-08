package com.tcop.dao;

import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Coupon;

public abstract interface CouponDao
  extends BaseDao<Coupon, Long>
{
  public abstract Page<Coupon> findPage(Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3, Pageable paramPageable);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.CouponDao
 * JD-Core Version:    0.7.0.1
 */