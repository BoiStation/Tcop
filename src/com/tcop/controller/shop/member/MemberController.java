package com.tcop.controller.shop.member;

import javax.annotation.Resource;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Member;
import com.tcop.service.ConsultationService;
import com.tcop.service.CouponCodeService;
import com.tcop.service.MemberService;
import com.tcop.service.MessageService;
import com.tcop.service.OrderService;
import com.tcop.service.ProductNotifyService;
import com.tcop.service.ProductService;
import com.tcop.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberController")
@RequestMapping({"/member"})
public class MemberController
  extends BaseController
{
  private static final int IIIlllIl = 6;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="orderServiceImpl")
  private OrderService IIIlllll;
  @Resource(name="couponCodeServiceImpl")
  private CouponCodeService IIlIIIII;
  @Resource(name="messageServiceImpl")
  private MessageService IIlIIIIl;
  @Resource(name="productServiceImpl")
  private ProductService IIlIIIlI;
  @Resource(name="productNotifyServiceImpl")
  private ProductNotifyService IIlIIIll;
  @Resource(name="reviewServiceImpl")
  private ReviewService IIlIIlII;
  @Resource(name="consultationServiceImpl")
  private ConsultationService IIlIIlIl;
  
  @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String index(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    model.addAttribute("waitingPaymentOrderCount", this.IIIlllll.waitingPaymentCount(localMember));
    model.addAttribute("waitingShippingOrderCount", this.IIIlllll.waitingShippingCount(localMember));
    model.addAttribute("messageCount", this.IIlIIIIl.count(localMember, Boolean.valueOf(false)));
    model.addAttribute("couponCodeCount", this.IIlIIIII.count(null, localMember, null, Boolean.valueOf(false), Boolean.valueOf(false)));
    model.addAttribute("favoriteCount", this.IIlIIIlI.count(localMember, null, null, null, null, null, null));
    model.addAttribute("productNotifyCount", this.IIlIIIll.count(localMember, null, null, null));
    model.addAttribute("reviewCount", this.IIlIIlII.count(localMember, null, null, null));
    model.addAttribute("consultationCount", this.IIlIIlIl.count(localMember, null, null));
    model.addAttribute("newOrders", this.IIIlllll.findList(localMember, Integer.valueOf(6), null, null));
    return "shop/member/index";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.MemberController
 * JD-Core Version:    0.7.0.1
 */