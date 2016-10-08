package com.tcop.controller.admin;

import javax.annotation.Resource;
import com.tcop.service.PluginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("adminStoragePluginController")
@RequestMapping({"/admin/storage_plugin"})
public class StoragePluginController
  extends BaseController
{
  @Resource(name="pluginServiceImpl")
  private PluginService IIIlllIl;
  
  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(ModelMap model)
  {
    model.addAttribute("storagePlugins", this.IIIlllIl.getStoragePlugins());
    return "/admin/storage_plugin/list";
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.controller.admin.StoragePluginController
 * JD-Core Version:    0.7.0.1
 */