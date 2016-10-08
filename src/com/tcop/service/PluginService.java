package com.tcop.service;

import java.util.List;
import com.tcop.plugin.PaymentPlugin;
import com.tcop.plugin.StoragePlugin;

public abstract interface PluginService
{
  public abstract List<PaymentPlugin> getPaymentPlugins();
  
  public abstract List<StoragePlugin> getStoragePlugins();
  
  public abstract List<PaymentPlugin> getPaymentPlugins(boolean paramBoolean);
  
  public abstract List<StoragePlugin> getStoragePlugins(boolean paramBoolean);
  
  public abstract PaymentPlugin getPaymentPlugin(String paramString);
  
  public abstract StoragePlugin getStoragePlugin(String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.PluginService
 * JD-Core Version:    0.7.0.1
 */