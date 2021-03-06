package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.service.ProductNotifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("ProductNotifyntroller")
@RequestMapping({"/admin/product_notify"})
public class ProductNotifyController
  extends BaseController
{
  @Resource(name="productNotifyServiceImpl")
  private ProductNotifyService IIIlllIl;
  
  @RequestMapping(value={"/send"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message send(Long[] ids)
  {
    int i = this.IIIlllIl.send(ids);
    return Message.success("admin.productNotify.sentSuccess", new Object[] { Integer.valueOf(i) });
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Boolean isMarketable, Boolean isOutOfStock, Boolean hasSent, Pageable pageable, ModelMap model)
  {
    model.addAttribute("isMarketable", isMarketable);
    model.addAttribute("isOutOfStock", isOutOfStock);
    model.addAttribute("hasSent", hasSent);
    model.addAttribute("page", this.IIIlllIl.findPage(null, isMarketable, isOutOfStock, hasSent, pageable));
    return "/admin/product_notify/list";
  }
  
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.ProductNotifyController
 * JD-Core Version:    0.7.0.1
 */