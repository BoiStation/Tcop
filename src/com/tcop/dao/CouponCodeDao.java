package com.tcop.dao;

import java.util.List;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.entity.Coupon;
import com.tcop.entity.CouponCode;
import com.tcop.entity.Member;

public abstract interface CouponCodeDao
  extends BaseDao<CouponCode, Long>
{
  public abstract boolean codeExists(String paramString);
  
  public abstract CouponCode findByCode(String paramString);
  
  public abstract CouponCode build(Coupon paramCoupon, Member paramMember);
  
  public abstract List<CouponCode> build(Coupon paramCoupon, Member paramMember, Integer paramInteger);
  
  public abstract Page<CouponCode> findPage(Member paramMember, Pageable paramPageable);
  
  public abstract Long count(Coupon paramCoupon, Member paramMember, Boolean paramBoolean1, Boolean paramBoolean2, Boolean paramBoolean3);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.CouponCodeDao
 * JD-Core Version:    0.7.0.1
 */