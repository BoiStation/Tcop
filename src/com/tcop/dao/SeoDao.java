package com.tcop.dao;

import com.tcop.entity.Seo;
import com.tcop.entity.Seo.Type;

public abstract interface SeoDao
  extends BaseDao<Seo, Long>
{
  public abstract Seo find(Seo.Type paramType);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.SeoDao
 * JD-Core Version:    0.7.0.1
 */