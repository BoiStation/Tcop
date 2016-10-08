package com.tcop.controller.admin;

import java.util.Date;
import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminPurchaseRankingController")
@RequestMapping({"/admin/purchase_ranking"})
public class PurchaseRankingController
  extends BaseController
{
  @Resource(name="memberServiceImpl")
  private MemberService IIIlllIl;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Date beginDate, Date endDate, Pageable pageable, Model model)
  {
    model.addAttribute("beginDate", beginDate);
    model.addAttribute("endDate", endDate);
    model.addAttribute("page", this.IIIlllIl.findPurchasePage(beginDate, endDate, pageable));
    return "/admin/purchase_ranking/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.PurchaseRankingController
 * JD-Core Version:    0.7.0.1
 */