package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.Page;
import com.tcop.Pageable;
import com.tcop.dao.CouponDao;
import com.tcop.entity.Coupon;
import com.tcop.service.CouponService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("couponServiceImpl")
public class CouponServiceImpl
  extends BaseServiceImpl<Coupon, Long>
  implements CouponService
{
  @Resource(name="couponDaoImpl")
  private CouponDao IIIllIlI;
  
  @Resource(name="couponDaoImpl")
  public void setBaseDao(CouponDao couponDao)
  {
    super.setBaseDao(couponDao);
  }
  
  @Transactional(readOnly=true)
  public Page<Coupon> findPage(Boolean isEnabled, Boolean isExchange, Boolean hasExpired, Pageable pageable)
  {
    return this.IIIllIlI.findPage(isEnabled, isExchange, hasExpired, pageable);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.CouponServiceImpl
 * JD-Core Version:    0.7.0.1
 */