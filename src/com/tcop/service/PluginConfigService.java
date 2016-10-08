package com.tcop.service;

import com.tcop.entity.PluginConfig;

public abstract interface PluginConfigService
  extends BaseService<PluginConfig, Long>
{
  public abstract boolean pluginIdExists(String paramString);
  
  public abstract PluginConfig findByPluginId(String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.PluginConfigService
 * JD-Core Version:    0.7.0.1
 */