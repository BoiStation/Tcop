package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.Message;
import com.tcop.Pageable;
import com.tcop.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("adminLogController")
@RequestMapping({"/admin/log"})
public class LogController
  extends BaseController
{
  @Resource(name="logServiceImpl")
  private LogService IIIlllIl;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, ModelMap model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(pageable));
    return "/admin/log/list";
  }
  
  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(Long id, ModelMap model)
  {
    model.addAttribute("log", this.IIIlllIl.find(id));
    return "/admin/log/view";
  }
  
  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long[] ids)
  {
    this.IIIlllIl.delete(ids);
    return IIIlllII;
  }
  
  @RequestMapping(value={"/clear"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message clear()
  {
    this.IIIlllIl.clear();
    return IIIlllII;
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.LogController
 * JD-Core Version:    0.7.0.1
 */