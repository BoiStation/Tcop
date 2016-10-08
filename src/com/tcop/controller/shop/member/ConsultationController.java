package com.tcop.controller.shop.member;

import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Member;
import com.tcop.service.ConsultationService;
import com.tcop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("shopMemberConsultationController")
@RequestMapping({"/member/consultation"})
public class ConsultationController
  extends BaseController
{
  private static final int IIIlllIl = 10;
  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;
  @Resource(name="consultationServiceImpl")
  private ConsultationService IIIlllll;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllll.findPage(localMember, null, null, localPageable));
    return "shop/member/consultation/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.ConsultationController
 * JD-Core Version:    0.7.0.1
 */