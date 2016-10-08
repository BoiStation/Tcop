package com.tcop.controller.shop.member;

import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Member;
import com.tcop.service.MemberService;
import com.tcop.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberReviewController")
@RequestMapping({"/member/review"})
public class ReviewController
  extends BaseController
{
  private static final int IIIlllIl = 10;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="reviewServiceImpl")
  private ReviewService IIIlllll;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(localMember, null, null, null, localPageable));
    return "shop/member/review/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.ReviewController
 * JD-Core Version:    0.7.0.1
 */