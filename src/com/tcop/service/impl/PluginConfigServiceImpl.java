package com.tcop.service.impl;

import javax.annotation.Resource;
import com.tcop.dao.PluginConfigDao;
import com.tcop.entity.PluginConfig;
import com.tcop.service.PluginConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("pluginConfigServiceImpl")
public class PluginConfigServiceImpl
  extends BaseServiceImpl<PluginConfig, Long>
  implements PluginConfigService
{
  @Resource(name="pluginConfigDaoImpl")
  private PluginConfigDao IIIllIlI;
  
  @Resource(name="pluginConfigDaoImpl")
  public void setBaseDao(PluginConfigDao pluginConfigDao)
  {
    super.setBaseDao(pluginConfigDao);
  }
  
  @Transactional(readOnly=true)
  public boolean pluginIdExists(String pluginId)
  {
    return this.IIIllIlI.pluginIdExists(pluginId);
  }
  
  @Transactional(readOnly=true)
  public PluginConfig findByPluginId(String pluginId)
  {
    return this.IIIllIlI.findByPluginId(pluginId);
  }
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.impl.PluginConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */