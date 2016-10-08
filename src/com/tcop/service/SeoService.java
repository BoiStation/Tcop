package com.tcop.service;

import com.tcop.entity.Seo;
import com.tcop.entity.Seo.Type;

public abstract interface SeoService
  extends BaseService<Seo, Long>
{
  public abstract Seo find(Seo.Type paramType);
  
  public abstract Seo find(Seo.Type paramType, String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.service.SeoService
 * JD-Core Version:    0.7.0.1
 */