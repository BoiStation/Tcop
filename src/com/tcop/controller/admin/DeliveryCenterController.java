package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.entity.Area;
import com.tcop.entity.DeliveryCenter;
import com.tcop.service.AreaService;
import com.tcop.service.DeliveryCenterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("deliveryCenterController")
@RequestMapping({"/admin/delivery_center"})
public class DeliveryCenterController
  extends BaseController
{
  @Resource(name="deliveryCenterServiceImpl")
  private DeliveryCenterService IIIlllIl;
  @Resource(name="areaServiceImpl")
  private AreaService IIIllllI;
  
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add()
  {
    return "/admin/delivery_center/add";
  }
  
  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(DeliveryCenter deliveryCenter, Long areaId, Model model, RedirectAttributes redirectAttributes)
  {
    deliveryCenter.setArea((Area)this.IIIllllI.find(areaId));
    if (!IIIllIlI(deliveryCenter, new Class[0])) {
      return "/admin/common/error";
    }
    deliveryCenter.setAreaName(null);
    this.IIIlllIl.save(deliveryCenter);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, Model model)
  {
    model.addAttribute("deliveryCenter", this.IIIlllIl.find(id));
    return "/admin/delivery_center/edit";
  }
  
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(DeliveryCenter deliveryCenter, Long areaId, RedirectAttributes redirectAttributes)
  {
    deliveryCenter.setArea((Area)this.IIIllllI.find(areaId));
    if (!IIIllIlI(deliveryCenter, new Class[0])) {
      return "/admin/common/error";
    }
    this.IIIlllIl.update(deliveryCenter, new String[] { "areaName" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Model model, Pageable pageable)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/delivery_center/list";
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
 * Qualified Name:     com.tcop.controller.admin.DeliveryCenterController
 * JD-Core Version:    0.7.0.1
 */