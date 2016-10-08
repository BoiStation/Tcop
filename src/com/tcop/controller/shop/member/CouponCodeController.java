package com.tcop.controller.shop.member;

import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Coupon;
import com.tcop.entity.Member;
import com.tcop.service.CouponCodeService;
import com.tcop.service.CouponService;
import com.tcop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopMemberCouponCodeController")
@RequestMapping({"/member/coupon_code"})
public class CouponCodeController
  extends BaseController
{
  private static final int IIIlllIl = 10;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="couponServiceImpl")
  private CouponService IIIlllll;
  @Resource(name="couponCodeServiceImpl")
  private CouponCodeService IIlIIIII;
  
  @RequestMapping(value={"/exchange"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String exchange(Integer pageNumber, ModelMap model)
  {
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(false), localPageable));
    return "shop/member/coupon_code/exchange";
  }
  
  @RequestMapping(value={"/exchange"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message exchange(Long id)
  {
    Coupon localCoupon = (Coupon)this.IIIlllll.find(id);
    if ((localCoupon == null) || (!localCoupon.getIsEnabled().booleanValue()) || (!localCoupon.getIsExchange().booleanValue()) || (localCoupon.hasExpired())) {
      return MESSAGE_ERROR;
    }
    Member localMember = this.IIIllllI.getCurrent();
    if (localMember.getPoint().longValue() < localCoupon.getPoint().intValue()) {
      return Message.warn("shop.member.couponCode.point", new Object[0]);
    }
    this.IIlIIIII.exchange(localCoupon, localMember);
    return MESSAGE_SUCCESS;
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIlIIIII.findPage(localMember, localPageable));
    return "shop/member/coupon_code/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.CouponCodeController
 * JD-Core Version:    0.7.0.1
 */