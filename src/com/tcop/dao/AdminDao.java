package com.tcop.dao;

import com.tcop.entity.Admin;

public abstract interface AdminDao
  extends BaseDao<Admin, Long>
{
  public abstract boolean usernameExists(String paramString);
  
  public abstract Admin findByUsername(String paramString);
}


/* Location:           D:\workspace\shopxx\WEB-INF\classes\
 * Qualified Name:     com.tcop.dao.AdminDao
 * JD-Core Version:    0.7.0.1
 */