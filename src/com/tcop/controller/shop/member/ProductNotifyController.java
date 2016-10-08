package com.tcop.controller.shop.member;

import java.util.Set;
import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.controller.shop.BaseController;
import com.tcop.entity.Member;
import com.tcop.entity.ProductNotify;
import com.tcop.service.MemberService;
import com.tcop.service.ProductNotifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("shopMemberProductNotifyController")
@RequestMapping({"/member/product_notify"})
public class ProductNotifyController
  extends BaseController
{
  private static final int IIIlllll = 10;
  @Resource(name="productNotifyServiceImpl")
  ProductNotifyService IIIlllIl;
  @Resource(name="memberServiceImpl")
  MemberService IIIllllI;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, Model model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIIlllIl.findPage(localMember, null, null, null, localPageable));
    return "/shop/member/product_notify/list";
  }
  
  @RequestMapping({"delete"})
  @ResponseBody
  public Message delete(Long id)
  {
    ProductNotify localProductNotify = (ProductNotify)this.IIIlllIl.find(id);
    if (localProductNotify == null) {
      return MESSAGE_ERROR;
    }
    Member localMember = this.IIIllllI.getCurrent();
    if (!localMember.getProductNotifies().contains(localProductNotify)) {
      return MESSAGE_ERROR;
    }
    this.IIIlllIl.delete(localProductNotify);
    return MESSAGE_SUCCESS;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.shop.member.ProductNotifyController
 * JD-Core Version:    0.7.0.1
 */