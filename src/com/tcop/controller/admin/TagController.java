package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.entity.BaseEntity;
import com.tcop.entity.BaseEntity.Save;
import com.tcop.entity.Tag;
import com.tcop.entity.Tag.Type;
import com.tcop.service.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminTagController")
@RequestMapping({"/admin/tag"})
public class TagController
  extends BaseController
{
  @Resource(name="tagServiceImpl")
  private TagService IIIlllIl;
  
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("types", Tag.Type.values());
    return "/admin/tag/add";
  }
  
  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Tag tag, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(tag, new Class[] { BaseEntity.Save.class })) {
      return "/admin/common/error";
    }
    tag.setArticles(null);
    tag.setProducts(null);
    this.IIIlllIl.save(tag);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    model.addAttribute("types", Tag.Type.values());
    model.addAttribute("tag", this.IIIlllIl.find(id));
    return "/admin/tag/edit";
  }
  
  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Tag tag, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(tag, new Class[0])) {
      return "/admin/common/error";
    }
    this.IIIlllIl.update(tag, new String[] { "type", "articles", "products" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/tag/list";
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
 * Qualified Name:     com.tcop.controller.admin.TagController
 * JD-Core Version:    0.7.0.1
 */