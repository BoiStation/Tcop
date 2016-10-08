package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Pageable;
import com.tcop.entity.Seo;
import com.tcop.service.SeoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminSeoController")
@RequestMapping({"/admin/seo"})
public class SeoController
  extends BaseController
{
  @Resource(name="seoServiceImpl")
  private SeoService IIIlllIl;
  
  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("seo", this.IIIlllIl.find(id));
    return "/admin/seo/edit";
  }
  
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Seo seo, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(seo, new Class[0])) {
      return "/admin/common/error";
    }
    this.IIIlllIl.update(seo, new String[] { "type" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/seo/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.SeoController
 * JD-Core Version:    0.7.0.1
 */