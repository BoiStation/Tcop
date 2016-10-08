package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Template;
import com.tcop.service.StaticService;
import com.tcop.service.TemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminSitemapController")
@RequestMapping({"/admin/sitemap"})
public class SitemapController
  extends BaseController
{
  @Resource(name="templateServiceImpl")
  private TemplateService IIIlllIl;
  @Resource(name="staticServiceImpl")
  private StaticService IIIllllI;
  
  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String build(ModelMap model)
  {
    Template localTemplate = this.IIIlllIl.get("sitemapIndex");
    model.addAttribute("sitemapIndexPath", localTemplate.getStaticPath());
    return "/admin/sitemap/build";
  }
  
  @RequestMapping(value={"/build"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String build(RedirectAttributes redirectAttributes)
  {
    this.IIIllllI.buildSitemap();
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:build.jhtml";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.SitemapController
 * JD-Core Version:    0.7.0.1
 */